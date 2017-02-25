package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

/**
 * Created by zigza on 25.02.2017.
 */
public abstract class AbstractHandler<T extends RequestData, R extends ResponseData> implements Handler {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }

    public abstract Response<R> process(Request<T> msg);
}
