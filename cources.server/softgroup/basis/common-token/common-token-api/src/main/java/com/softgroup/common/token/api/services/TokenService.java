package com.softgroup.common.token.api.services;

import com.softgroup.common.token.api.exception.TokenException;
import org.springframework.stereotype.Service;

/**
 * Created by zigza on 31.03.2017.
 */
@Service
public interface TokenService {
    boolean validateSessionToken(String token);
    boolean validateDeviceToken(String token);
    String generateSessionToken(String userId, String deviceId,String name,String phone);
    String generateDeviceToken(String userId, String deviceId,String name,String phone);
    Long getCreationTime(String token) throws TokenException;
    Long getExpirationTime(String token) throws TokenException;
    TokenType getTokenType(String token) throws TokenException;
    <T> T getParameter (String token, String key) throws TokenException;
    public String getDeviceId(String token);
    public String getUserId(String token);
    public String getName(String token);
    public String getPhone(String token);
}
