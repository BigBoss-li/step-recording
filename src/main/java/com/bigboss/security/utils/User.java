package com.bigboss.security.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
public class User implements UserDetails {

    private String id;
    private String username;
    private String password;

    private Boolean isAccountNoExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAccountNoExpired = false;
        this.isAccountNonLocked = false;
        this.isCredentialsNonExpired = false;
        this.isEnabled = true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.username;
    }

    @Override
    public String getUsername() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountNoExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
