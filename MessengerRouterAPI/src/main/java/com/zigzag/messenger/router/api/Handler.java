package com.zigzag.messenger.router.api;


import com.zigzag.messenger.protocol.api.request.Request;
import com.zigzag.messenger.protocol.api.response.Response;


public interface Handler {
    String getName();

    Response<?> handle(final Request<?> msg);
}
