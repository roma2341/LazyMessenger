package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.Action;
import com.zigzag.messenger.protocol.api.ActionHeader;
import com.zigzag.messenger.protocol.api.Data;

import java.io.Serializable;

/**
 * Created by zigza on 22.02.2017.
 */
public class MessengerAction<T extends Data> implements Action<T> {
    private ActionHeader header;

    private T data;

    public ActionHeader getHeader() {
        return header;
    }

    public void setHeader(ActionHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
