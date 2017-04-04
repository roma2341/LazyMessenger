package com.softgroup.frontend.security;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.token.impl.services.JwtTokenService;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by zigza on 31.03.2017.
 */
@Component
public class TokenAuthenticationManager implements AuthenticationManager {

    @Autowired
    private JwtTokenService tokenService;
    @Autowired
    private UserProfileService userProfileService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        /*try {
            if (authentication instanceof TokenAuthentication) {
                TokenAuthentication readyTokenAuthentication = processAuthentication((TokenAuthentication) authentication);
                return readyTokenAuthentication;
            } else {
                authentication.setAuthenticated(false);
                return authentication;
            }
        } catch (Exception ex) {
            if(ex instanceof AuthenticationServiceException)
                throw ex;
        }
        return null;*/
        return authentication;
    }

    private TokenAuthentication processAuthentication(TokenAuthentication authentication) throws AuthenticationException {
        String token = authentication.getToken();
        DefaultClaims tokenClaims = tokenService.getClaims(token);
        if(!tokenService.validateSessionToken(token))
            throw new AuthenticationServiceException("Invalid token");

        Date expiredDate = new Date(tokenService.getExpirationTime(token));
        if (expiredDate.after(new Date()))
            return buildFullTokenAuthentication(authentication, tokenClaims);
        else
            throw new AuthenticationServiceException("Token expired date error");
    }

    private TokenAuthentication buildFullTokenAuthentication(TokenAuthentication authentication, DefaultClaims claims) {
        String userId = tokenService.getUserId(authentication.getToken());
        UserProfile user = userProfileService.getProfile(userId);
        boolean isUserEnabled = true;
        if (isUserEnabled) {//TODO user.isEnabled()
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();//TODO user.getAuthorities();
            TokenAuthentication fullTokenAuthentication =
                    new TokenAuthentication(authentication.getToken(), authorities, true, user);
            return fullTokenAuthentication;
        } else {
            throw new AuthenticationServiceException("User disabled");
        }
    }
}
