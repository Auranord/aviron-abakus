package de.aviron.abakus.enums;

import static de.aviron.abakus.enums.UserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
    NONE(Sets.newHashSet()),
    TRIAL(Sets.newHashSet(USER_READ, FIGURE_READ)),
    MEMBER(Sets.newHashSet(USER_READ, FIGURE_READ)),
    RECRUITER(Sets.newHashSet(USER_READ, FIGURE_READ)),
    GAMEMASTER(Sets.newHashSet(USER_READ, USER_WRITE, FIGURE_READ, FIGURE_WRITE)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, FIGURE_READ, FIGURE_WRITE));

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
