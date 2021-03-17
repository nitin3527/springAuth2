package com.example.springsecurityauth2bootcamp.auth;

import org.springframework.security.core.GrantedAuthority;

public class GrantAuthorityImpl implements GrantedAuthority {
    String authority;

    public GrantAuthorityImpl(String role) {
        this.authority = role;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
