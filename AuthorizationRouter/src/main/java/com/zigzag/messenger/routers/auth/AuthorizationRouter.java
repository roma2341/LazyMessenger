package com.zigzag.messenger.routers.auth;

import com.zigzag.messenger.protocol.api.request.Request;
import com.zigzag.messenger.router.api.AuthorizationRouterHandler;
import com.zigzag.messenger.router.api.Router;

/**
 * Created by zigza on 24.02.2017.
 */
public class AuthorizationRouter extends Router<AuthorizationRouterHandler> {

    @Override
    public String getRouteKey(Request<?> msg) {
        return "authorization";
    }

    @Override
    public String getName() {
        return "authorization";
    }
}
