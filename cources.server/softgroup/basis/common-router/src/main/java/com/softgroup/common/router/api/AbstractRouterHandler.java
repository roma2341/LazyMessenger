package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.factory.RequestHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends RequestHandler> implements RouterHandler {

	@Autowired
	RequestHandlerFactory<T> requestHandlerFactory;

	 protected AbstractHandlerFactory getHandlerFactory(){
		return requestHandlerFactory;
	}
	@Override
	public String getRouteKey(Request<?> msg){
		return msg.getHeader().getCommand();
	}

	@Override
	public Response<?> handle(Request<?> msg) {
		Handler handler = getHandlerFactory().getHandler(msg);
		return handler.handle(msg);
	}

}
