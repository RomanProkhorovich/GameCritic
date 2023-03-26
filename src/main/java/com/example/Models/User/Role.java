package com.example.Models.User;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.DEVELOPER_WRITE,Permission.DEVELOPER_READ)),
    USERS(Set.of(Permission.DEVELOPER_READ));
    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        var a=getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        return a;
    }
}
