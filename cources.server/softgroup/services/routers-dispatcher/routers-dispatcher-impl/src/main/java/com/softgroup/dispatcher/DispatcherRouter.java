package com.softgroup.dispatcher;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.CommonRouterHandler;

/**
 * Created by zigza on 25.02.2017.
 */
public class DispatcherRouter  extends DispatcherRouterHandler<CommonRouterHandler> {
    public String getName() {
        return null;
    }

    public String getRouteKey(Request<?> msg) {
        return null;
    }
}
