package com.zigzag.messenger.router.api;


import com.zigzag.messenger.protocol.api.request.Request;
import com.zigzag.messenger.protocol.api.request.data.RequestData;
import com.zigzag.messenger.protocol.api.response.Response;
import com.zigzag.messenger.protocol.api.response.data.ResponseData;

/**
 * Created by zigza on 25.02.2017.
 */
public class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<R> handle(Request<?> msg) {
        return null;
    }
}
