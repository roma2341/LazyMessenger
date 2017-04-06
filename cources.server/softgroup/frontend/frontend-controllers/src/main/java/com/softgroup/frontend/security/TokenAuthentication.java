package com.softgroup.frontend.security;

import com.softgroup.common.router.api.UserProfilePrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

/**
 * Created by zigza on 31.03.2017.
 */
public class TokenAuthentication implements Authentication {
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAuthenticated;
    private UserProfilePrincipal principal;

    public TokenAuthentication(UserProfilePrincipal principal) {
    this.principal = principal;
    }

    public TokenAuthentication( Collection<SimpleGrantedAuthority> authorities, boolean isAuthenticated,
                               UserProfilePrincipal principal) {
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
        return ((UserProfilePrincipal)principal).getName();
    }

    @Override
    public UserProfilePrincipal getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }



}
