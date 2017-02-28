package com.softgroup.authorithation.impl.handler;

import com.softgroup.services.authorization.api.handler.AuthorizationHandler;
import com.softgroup.services.authorization.api.message.request.SmsConfirmRequestData;
import com.softgroup.services.authorization.api.message.response.SmsConfirmResponseData;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class SmsConfirmRequestHandler  extends AbstractRequestHandler<SmsConfirmRequestData,SmsConfirmResponseData> implements AuthorizationHandler {
    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SmsConfirmResponseData> process(Request<SmsConfirmRequestData> request) {
       SmsConfirmResponseData responseData = new  SmsConfirmResponseData();
        responseData.setDeviceToken("not set");

        Response<SmsConfirmResponseData> response = new Response<SmsConfirmResponseData>();
        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");

        response.setStatus(status);
        return response;
    }
}
