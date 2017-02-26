package com.softgroup.authorithation.impl.router;

import com.softgroup.authorithation.impl.handler.RegistrationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class AuthorizationRouter<T extends RegistrationRequestHandler> extends AbstractRouterHandler<T>  {

    public String getName() {
        return "authorization";
    }
}
