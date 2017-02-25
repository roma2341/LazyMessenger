package com.zigzag.messenger.routers.auth.handlers;

import com.zigzag.messenger.API.database.services.ProfileService;
import com.zigzag.messenger.protocol.api.request.Request;
import com.zigzag.messenger.protocol.api.response.Response;
import com.zigzag.messenger.router.api.AuthorizationRouterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zigza on 23.02.2017.
 */
public class AuthorizationRouterHandlerRegistration implements AuthorizationRouterHandler{
    private final static Logger logger = LoggerFactory.getLogger(AuthorizationRouterHandlerRegistration.class);
    @Autowired
    private ProfileService profileService;
    @Override
    public String getRouteKey(Request<?> msg) {
        return "register";
    }

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response handle(Request msg) {
        msg.getData();
        logger.info("user was registered");
        return null;
    }


}
