package com.zigzag.messenger.API.security;

/**
 * Created by zigza on 17.02.2017.
 */
public interface CryptService {
    public String decrypt(String source);
    public String encrypt(String source);
}
