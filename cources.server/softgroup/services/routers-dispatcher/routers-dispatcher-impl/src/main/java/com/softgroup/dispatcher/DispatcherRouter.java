package com.softgroup.dispatcher;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.*;
import com.softgroup.common.router.factory.DispatcherHandlerFactory;
import com.softgroup.common.router.factory.RequestHandlerFactory;
import com.softgroup.common.router.factory.RouterHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class DispatcherRouter {

    DispatcherHandlerFactory handlerFactory;
    protected AbstractHandlerFactory getHandlerFactory(){
        return handlerFactory;
    }
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }

    public String getName() {
        return "main_router";
    }
    public Response<?> handle(Request<?> msg) {
        Handler handler = getHandlerFactory().getHandler(msg);
        return handler.handle(msg);
    }

}
