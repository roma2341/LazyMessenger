package com.softgroup.authorithation.impl.services;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zigza on 08.03.2017.
 */
@Service
public class TokenService {
    Map<String,String> tokens;
    public String generateTokenByDeviceToken(String deviceToken){
        String token =  tokens.get(deviceToken);
        return token == null ? "" : token;
    }

}
