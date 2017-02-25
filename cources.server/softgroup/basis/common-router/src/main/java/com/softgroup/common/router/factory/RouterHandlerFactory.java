package com.softgroup.common.router.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractHandlerFactory;
import com.softgroup.common.router.api.Handler;

/**
 * Created by zigza on 25.02.2017.
 */
public class RouterHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> {

    @Override
    protected String getCommand(Request msg) {
        return  msg.getHeader().getType();
    }

}
