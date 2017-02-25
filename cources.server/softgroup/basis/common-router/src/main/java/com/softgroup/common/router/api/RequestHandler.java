package com.softgroup.common.router.api;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.ResponseData;

public interface RequestHandler<T extends RequestData, R extends ResponseData> extends Handler {
}
