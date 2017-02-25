package com.zigzag.messenger.protocol.api;

import java.io.Serializable;

/**
 * Created by zigza on 23.02.2017.
 */
public interface Action<T extends Data> extends Serializable {
    public T getData();
    public void setData(T data);
    public ActionHeader getHeader();
    public void setHeader(ActionHeader header);
}
