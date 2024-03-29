package com.example.Security;

import com.example.Models.User.Status;
import com.example.Models.User.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserSecurity implements UserDetails {
    private final String username;
    private final String password;
    private final Set<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public UserSecurity(String username, String password, Set<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getNickname()
                ,user.getPassword()
                ,user.getActive().equals(Status.ACTIVE),
                user.getActive().equals(Status.ACTIVE),
                user.getActive().equals(Status.ACTIVE),
                user.getActive().equals(Status.ACTIVE),
                user.getRole().getAuthorities());
    }
}
