package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.ResponseStatus;

import java.io.Serializable;

public class MessengerResponseStatus implements ResponseStatus {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
