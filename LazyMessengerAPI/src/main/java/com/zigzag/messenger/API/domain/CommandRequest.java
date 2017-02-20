package com.zigzag.messenger.API.domain;

/**
 * Created by zigza on 19.02.2017.
 */

/***
 *
 * @param <T> data type
 */
public interface CommandRequest<T extends CommandData> {
    public String getCommand();
    public T getData();
    public CommandResponse process();
}
