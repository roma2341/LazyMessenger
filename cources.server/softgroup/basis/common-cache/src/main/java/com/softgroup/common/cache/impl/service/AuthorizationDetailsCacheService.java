package com.softgroup.common.cache.impl.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.softgroup.common.cache.api.data.AuthorizationDetails;
import com.softgroup.common.cache.api.data.CacheData;
import com.softgroup.common.cache.api.service.BasicCacheService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.LoadingCache;

/**
 * Created by zigza on 30.03.2017.
 */
public class AuthorizationDetailsCacheService extends BasicCacheService<AuthorizationDetails> {
    private final static int CACHE_EXPIRATION_TIME_MINUTES = 5;
    private final static int CACHE_SIZE_MAX = 1000;

    private static LoadingCache<String, AuthorizationDetails> cache;

    static {
        cache = CacheBuilder.newBuilder()
                .maximumSize(CACHE_SIZE_MAX)
                .expireAfterWrite(CACHE_EXPIRATION_TIME_MINUTES, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AuthorizationDetails>() {
                    public AuthorizationDetails load(String key) {
                        return getFromCache(key);
                    }
                });
    }

    private static AuthorizationDetails getFromCache(String key) {
        AuthorizationDetails details = null;
        try{
            details = cache.get(key);
        }
        catch(ExecutionException e){
            return details;
        }
        return details;
    }

    @Override
    public void put(AuthorizationDetails authorizationDetails) {
        cache.put(authorizationDetails.getRegistrationRequestUuid(),
                authorizationDetails);
    }

    @Override
    public AuthorizationDetails get(String key) throws ExecutionException {
        return cache.get(key);
    }

}
