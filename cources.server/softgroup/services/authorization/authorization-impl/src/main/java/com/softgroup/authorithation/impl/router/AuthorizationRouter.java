package com.softgroup.authorithation.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.RouterHandler;

/**
 * Created by zigza on 25.02.2017.
 */
public class AuthorizationRouter extends AbstractRouterHandler implements RouterHandler, CommonRouterHandler {
    public String getName() {
        return "authorization";
    }
}
