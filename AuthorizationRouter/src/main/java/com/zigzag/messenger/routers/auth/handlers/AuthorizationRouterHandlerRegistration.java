package com.zigzag.messenger.routers.auth.handlers;

import com.zigzag.messenger.protocol.api.Request;
import com.zigzag.messenger.router.api.AuthorizationRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Response;

/**
 * Created by zigza on 23.02.2017.
 */
public class AuthorizationRouterHandlerRegistration implements AuthorizationRouterHandler {

    @Override
    public String getRouteKey(Request<?> msg) {
        return "register";
    }

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<?> handle(Request<?> msg) {

        return null;
    }
}
