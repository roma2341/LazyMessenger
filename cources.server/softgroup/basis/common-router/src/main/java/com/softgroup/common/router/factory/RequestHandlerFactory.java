package com.softgroup.common.router.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractHandlerFactory;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.HandlerFactory;
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
public class RequestHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> {

    @Override
    protected String getCommand(Request msg) {
        return  msg.getHeader().getCommand();
    }
}
