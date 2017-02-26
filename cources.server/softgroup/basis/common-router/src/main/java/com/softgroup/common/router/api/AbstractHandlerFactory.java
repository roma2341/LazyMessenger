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
public abstract class AbstractHandlerFactory<T extends Handler> {
    List<T> handlers;
    Map<String,T> handlersMap = new HashMap<String,T>();
    protected abstract List<T>  getHandlers();

    @PostConstruct
    public void init(){
        for (T handler : getHandlers()){
            handlersMap.put(handler.getName(),handler);
        }
    }
    protected abstract String getCommand(Request<?> msg);

    public T getHandler(Request msg) {
        String command = getCommand(msg);
        T handler = handlersMap.get(command);
        return handler;
    }
}
