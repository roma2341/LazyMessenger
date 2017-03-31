package com.softgroup.common.cache.api.service;

import com.softgroup.common.cache.api.data.CacheData;

import java.util.concurrent.ExecutionException;

/**
 * Created by zigza on 30.03.2017.
 */
public abstract class BasicCacheService <T extends CacheData> {
    public abstract void put(T value);
    public abstract T get(String key) throws ExecutionException;
}
