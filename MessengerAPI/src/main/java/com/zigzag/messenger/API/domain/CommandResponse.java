package com.zigzag.messenger.API.domain;

/**
 * Created by zigza on 19.02.2017.
 */
public interface CommandResponse<T> {
    public String getCommand();
    public T getData();
}
