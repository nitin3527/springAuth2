package com.example.springsecurityauth2bootcamp.auth;

import com.example.springsecurityauth2bootcamp.entites.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

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
