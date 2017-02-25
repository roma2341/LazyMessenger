package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;

/**
 * Created by zigza on 25.02.2017.
 */
public interface HandlerFactory<T extends Handler> {
   public T getHandler(Request msg);
}
