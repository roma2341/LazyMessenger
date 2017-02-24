package com.zigzag.messenger.router.api;
import com.zigzag.messenger.protocol.api.Request;


public interface RouterHandler extends Handler {
	String getRouteKey(final Request<?> msg);
}
