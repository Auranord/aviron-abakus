package de.aviron.abakus.enums;

import static de.aviron.abakus.enums.UserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
    NONE(Sets.newHashSet(USER_OWN)),
    TRIAL(Sets.newHashSet(USER_READ, FIGURE_READ, USER_OWN)),
    MEMBER(Sets.newHashSet(USER_READ, FIGURE_READ, USER_OWN)),
    RECRUITER(Sets.newHashSet(USER_READ, FIGURE_READ, USER_OWN)),
    GAMEMASTER(Sets.newHashSet(USER_READ, USER_WRITE, FIGURE_READ, FIGURE_WRITE, USER_OWN)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, FIGURE_READ, FIGURE_WRITE, USER_OWN));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority>permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
