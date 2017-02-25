package com.zigzag.messenger.router.api;
import com.zigzag.messenger.protocol.api.request.Request;


public interface RouterHandler extends Handler {
	String getRouteKey(final Request<?> msg);
}
