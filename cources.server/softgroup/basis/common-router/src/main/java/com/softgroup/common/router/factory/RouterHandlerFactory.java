package com.softgroup.common.router.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractHandlerFactory;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zigza on 26.02.2017.
 */
public class RouterHandlerFactory<T extends AbstractRouterHandler> extends AbstractHandlerFactory<T> {
    @Override
    protected String getCommand(Request<?> msg) {
        return msg.getHeader().getType();
    }
    @Autowired
    List<T> handlers;

    @Override
    protected List<T> getHandlers() {
        return handlers;
    }
}
