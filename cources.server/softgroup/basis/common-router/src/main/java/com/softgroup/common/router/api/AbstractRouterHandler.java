package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

	@Autowired
	List<T> handlers;

	Map<String,T> handlersMap;

	@PostConstruct
	public void init(){
		handlersMap = new HashMap<String,T>();
		for (T handler : handlers){
			handlersMap.put(handler.getName(),handler);
		}
	}

	@Override
	public String getRouteKey(Request<?> msg){
		return msg.getHeader().getCommand();
	}

	@Override
	public Response<?> handle(Request<?> msg) {
		String command = msg.getHeader().getCommand();
		Handler handler = handlersMap.get(command);
		return handler.handle(msg);
	}

}
