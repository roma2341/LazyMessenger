package com.softgroup.authorithation.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.services.authorization.api.handler.AuthorizationHandler;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class AuthorizationRouter<T extends AuthorizationHandler> extends AbstractRouterHandler<T> implements CommonRouterHandler  {

    public String getName() {
        return "authorization";
    }
}
