package com.softgroup.dispatcher;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.HandlerFactory;
import com.softgroup.common.router.api.RouterHandler;
import com.softgroup.common.router.factory.RouterHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zigza on 25.02.2017.
 */
public abstract class DispatcherRouterHandler <T extends CommonRouterHandler> extends AbstractRouterHandler<T> {
    @Autowired
    RouterHandlerFactory<T> commonHandlerFactory;

    protected HandlerFactory getHandlerFactory(){
        return commonHandlerFactory;
    }

}
