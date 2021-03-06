package de.aviron.abakus.enums;

import static de.aviron.abakus.enums.UserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
    NONE(Sets.newHashSet(TEST_TEST)),
    TRIAL(Sets.newHashSet(TEST_TEST)),
    MEMBER(Sets.newHashSet(TEST_TEST)),
    RECRUITER(Sets.newHashSet(TEST_TEST)),
    GAMEMASTER(Sets.newHashSet(TEST_TEST)),
    ADMIN(Sets.newHashSet(TEST_TEST));

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
