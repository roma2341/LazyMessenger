package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zigza on 25.02.2017.
 */
public abstract class AbstractHandlerFactory<T extends Handler> implements HandlerFactory {
    @Autowired
    List<T> handlers;

    Map<String,T> handlersMap = new HashMap<String,T>();

    @PostConstruct
    public void init(){
        for (T handler : handlers){
            handlersMap.put(handler.getName(),handler);
        }
    }
    protected abstract String getCommand(Request<?> msg);

    @Override
    public T getHandler(Request msg) {
        String command = msg.getHeader().getCommand();
        T handler = handlersMap.get(command);
        return handler;
    }
}
