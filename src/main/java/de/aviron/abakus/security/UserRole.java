package de.aviron.abakus.security;

import static de.aviron.abakus.security.UserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
    TRIAL(Sets.newHashSet(FIGURE_READ)),
    MEMBER(Sets.newHashSet(FIGURE_READ)),
    BANNED(Sets.newHashSet(FIGURE_READ)),
    RECRUITER(Sets.newHashSet(FIGURE_READ)),
    GAMEMASTER(Sets.newHashSet(FIGURE_READ)),
    ADMIN(Sets.newHashSet(FIGURE_READ));

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
