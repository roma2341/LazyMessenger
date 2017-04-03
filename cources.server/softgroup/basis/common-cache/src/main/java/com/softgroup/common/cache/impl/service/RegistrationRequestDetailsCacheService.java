package com.softgroup.common.cache.impl.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.softgroup.common.cache.api.data.RegistrationRequestDetails;
import com.softgroup.common.cache.api.service.BasicCacheService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 30.03.2017.
 */
@Component
public class RegistrationRequestDetailsCacheService extends BasicCacheService<RegistrationRequestDetails> {
    private final static int CACHE_EXPIRATION_TIME_MINUTES = 5;
    private final static int CACHE_SIZE_MAX = 1000;

    private static LoadingCache<String, RegistrationRequestDetails> cache;

    static {
        cache = CacheBuilder.newBuilder()
                .maximumSize(CACHE_SIZE_MAX)
                .expireAfterWrite(CACHE_EXPIRATION_TIME_MINUTES, TimeUnit.MINUTES)
                .build(new CacheLoader<String, RegistrationRequestDetails>() {
                    public RegistrationRequestDetails load(String key) {
                        return getFromCache(key);
                    }
                });
    }

    private static RegistrationRequestDetails getFromCache(String key) {
        RegistrationRequestDetails details = null;
        try{
            details = cache.get(key);
        }
        catch(ExecutionException e){
            return details;
        }
        return details;
    }

    @Override
    public void put(RegistrationRequestDetails registrationRequestDetails) {
        cache.put(registrationRequestDetails.getRegistrationRequestUuid(),
                registrationRequestDetails);
    }

    @Override
    public RegistrationRequestDetails get(String key) throws ExecutionException {
        return cache.get(key);
    }

}
