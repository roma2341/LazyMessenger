package com.softgroup.common.token.impl.services;


import com.softgroup.common.token.api.exception.DeviceTokenException;
import com.softgroup.common.token.api.exception.TokenException;
import com.softgroup.common.token.api.services.TokenService;
import com.softgroup.common.token.api.services.TokenType;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Created by zigza on 31.03.2017.
 */
@Component("jwtTokenService")
public class JwtTokenService implements TokenService {

    private final static String signingKey = UUID.randomUUID().toString();
    private final Long DEVICE_TOKEN_EXPIRATION_MS = 365L * 24L * 60L * 60L * 1000L;//Year
    private final Long SESSION_TOKEN_EXPIRATION_MS = 60L * 10L * 1000L;//Ten minutes

    private final String USER_ID_PARAMETER_NAME="userId";
    private final String DEVICE_ID_PARAMETER_NAME="deviceId";
    private final String TOKEN_TYPE_PARAMETER_NAME="tokenType";


    @Override
    public boolean validateSessionToken(String token) {
        if(token==null || token.length()<1) return false;
        return validateToken(TokenType.SESSION, token);
    }

    @Override
    public boolean validateDeviceToken(String token) {
        if(token==null || token.length()<1) return false;
        return validateToken(TokenType.DEVICE, token);
    }

    @Override
    public String generateSessionToken(String userId, String deviceId) {
        HashMap<String,Object> claims = new HashMap();
        claims.put(USER_ID_PARAMETER_NAME, userId);
        claims.put(DEVICE_ID_PARAMETER_NAME, deviceId);
        return generateToken(claims,TokenType.SESSION, SESSION_TOKEN_EXPIRATION_MS);
    }

    @Override
    public String generateDeviceToken(String userId, String deviceId) {
        HashMap<String,Object> claims = new HashMap();
        claims.put(USER_ID_PARAMETER_NAME, userId);
        claims.put(DEVICE_ID_PARAMETER_NAME, deviceId);
        return generateToken(claims,TokenType.DEVICE, DEVICE_TOKEN_EXPIRATION_MS);
    }

    @Override
    public String getDeviceId(String token){
        if(token==null || token.length()<1) return null;
        return (String)getParameter(token,DEVICE_ID_PARAMETER_NAME );
    }

    @Override
    public String getUserId(String token) {
        if(token==null || token.length()<1) return null;
        return (String)getParameter(token,USER_ID_PARAMETER_NAME);
    }

    public Object getParameter(String token, String key) throws TokenException {
        if(token==null || token.length()<1) return null;
        return  Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody()
                .get(key);
    }

    @Override
    public Long getCreationTime(String token) throws TokenException {
        if(token==null || token.length()<1) return null;
        try {
            return Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody().getIssuedAt().getTime();
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    @Override
    public Long getExpirationTime(String token) throws TokenException {
        Long creationTime = getCreationTime(token);
        Long expirationTime = creationTime + SESSION_TOKEN_EXPIRATION_MS;
        return expirationTime;
    }

    @Override
    public TokenType getTokenType(String token) throws TokenException {
        if(token==null || token.length()<1) return null;
        try {
            return (TokenType) getParameter(token, TOKEN_TYPE_PARAMETER_NAME);
        } catch (JwtException jwtException){
            throw new TokenException(jwtException.getMessage());
        }
    }

    private boolean validateToken(TokenType tokenType, String token) {
        if(token==null || token.length()<1) return false;
        try{
            Jwts.parser()
                    .require(TOKEN_TYPE_PARAMETER_NAME, tokenType)
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token);
        } catch (JwtException jwtException){
            throw new DeviceTokenException(jwtException.getMessage());
        }
        return true;
    }
    private String generateToken(Map<String,Object> claims,TokenType tokenType,Long timeOutMs) throws DeviceTokenException {

        return  Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + timeOutMs))
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }
    public DefaultClaims getClaims(String token){
        return (DefaultClaims)Jwts.parser()
                .setSigningKey(signingKey)
                .parse(token).getBody();
    }


}
