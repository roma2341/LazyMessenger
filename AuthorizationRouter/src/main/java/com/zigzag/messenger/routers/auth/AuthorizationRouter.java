package com.zigzag.messenger.routers.auth;

import com.zigzag.messenger.protocol.api.Request;
import com.zigzag.messenger.router.api.AuthorizationRouterHandler;
import com.zigzag.messenger.router.api.Router;
import com.zigzag.messenger.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

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
