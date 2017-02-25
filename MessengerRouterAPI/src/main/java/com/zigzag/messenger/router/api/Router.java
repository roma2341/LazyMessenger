package com.zigzag.messenger.router.api;

import com.zigzag.messenger.protocol.api.request.Request;
import com.zigzag.messenger.protocol.api.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by zigza on 24.02.2017.
 */
public abstract class Router<T extends RouterHandler> implements RouterHandler {
    @Autowired
    List<T> handlers;

    Map<String,T> handlersMap;

    @PostConstruct
    public void initialize(){
        for (T handler : handlers) {
            handlersMap.put(handler.getName(),handler);
        }
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        String command = msg.getHeader().getCommand();
        return handlersMap.get(command).handle(msg);
    }
}
