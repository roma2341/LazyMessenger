package com.softgroup.common.router.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractHandlerFactory;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zigza on 26.02.2017.
 */
public class DispatcherHandlerFactory extends AbstractHandlerFactory<CommonRouterHandler> {
    @Override
    protected String getCommand(Request<?> msg) {
        return msg.getHeader().getType();
    }
    @Autowired
    List<CommonRouterHandler> handlers;

    @Override
    protected List<CommonRouterHandler> getHandlers() {
        return handlers;
    }
}
