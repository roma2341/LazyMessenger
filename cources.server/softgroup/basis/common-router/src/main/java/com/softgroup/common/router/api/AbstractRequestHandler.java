package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.utils.CommonReflectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {
	@Override
	public String getName() {
		return null;
	}

	@Override
	public Response<R> handle(Request<?> msg) {
		Request<T> request = new Request<T>();
		request.setHeader(msg.getHeader());
		JacksonDataMapper mapper = new JacksonDataMapper();

		/*Class currentClass = this.getClass();
		ParameterizedType type = (ParameterizedType) currentClass.getGenericSuperclass();
		Class parameter = (Class) type.getActualTypeArguments()[0];
		T data = mapper.convert((Map<String,Object>)msg.getData(),(Class<T>)parameter);*/
		T data = CommonReflectionUtils.getGenericParameterClass(this.getClass(), 0);
		request.setData(data);
		return process(request);
	}

	public abstract Response<R> process(Request<T> request);

}
