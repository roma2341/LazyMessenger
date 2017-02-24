package com.zigzag.messenger.router.api;


import com.zigzag.messenger.protocol.api.Request;

import javax.xml.ws.Response;


public interface Handler {
    String getName();

    Response<?> handle(final Request<?> msg);
}
