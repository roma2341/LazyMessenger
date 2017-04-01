package com.softgroup.common.token.api.services;

import com.softgroup.common.token.api.exception.TokenException;

/**
 * Created by zigza on 31.03.2017.
 */
public interface TokenService {
    boolean validateSessionToken(String token);
    boolean validateDeviceToken(String token);
    String generateSessionToken(String userId, String deviceId);
    String generateDeviceToken(String userId, String deviceId);
    Long getCreationTime(String token) throws TokenException;
    TokenType getTokenType(String token) throws TokenException;
    <T> T getParameter (String token, String key) throws TokenException;
    public String getDeviceId(String token);
    public String getUserId(String token);
}
