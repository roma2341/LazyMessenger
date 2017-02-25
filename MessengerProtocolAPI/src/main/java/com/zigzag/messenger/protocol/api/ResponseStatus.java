package com.zigzag.messenger.protocol.api;

import java.io.Serializable;

/**
 * Created by zigza on 23.02.2017.
 */
public interface ResponseStatus extends Serializable {
    public Integer getCode();

    public void setCode(Integer code);

    public String getMessage();

    public void setMessage(String message);
}
