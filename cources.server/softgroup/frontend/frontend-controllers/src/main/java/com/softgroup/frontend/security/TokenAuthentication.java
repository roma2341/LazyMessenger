package com.softgroup.frontend.security;

import com.softgroup.common.database.model.UserProfile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by zigza on 31.03.2017.
 */
public class TokenAuthentication implements Authentication {
    private String token;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAuthenticated;
    private UserProfile principal;

    public TokenAuthentication(String token) {
        this.token = token;
    }

    public TokenAuthentication(String token, Collection<SimpleGrantedAuthority> authorities, boolean isAuthenticated,
                               UserProfile principal) {
        this.token = token;
        this.authorities = authorities;
        this.isAuthenticated = isAuthenticated;
        this.principal = principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
    return null;
    }

    @Override
    public String getName() {
        if (principal != null)
            return ((UserProfile) principal).getName();
        else
            return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    public String getToken() {
        return token;
    }

}
