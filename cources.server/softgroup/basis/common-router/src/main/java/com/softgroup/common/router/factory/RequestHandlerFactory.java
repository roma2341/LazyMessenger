package com.softgroup.common.router.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class RequestHandlerFactory<T extends RequestHandler> extends AbstractHandlerFactory<T> {
    @Autowired
    List<T> handlers;

    @Override
    protected String getCommand(Request msg) {
        return  msg.getHeader().getCommand();
    }

    @Override
    protected List<T> getHandlers() {
        return handlers;
    }
}
