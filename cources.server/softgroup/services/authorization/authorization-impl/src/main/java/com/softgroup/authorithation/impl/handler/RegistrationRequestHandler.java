package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegistrationRequestData;
import com.softgroup.authorization.api.message.RegistrationResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class RegistrationRequestHandler extends AbstractRequestHandler<RegistrationRequestData,RegistrationResponseData> implements AuthorizationRequestHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "register";
    }

    public Response<RegistrationResponseData> process(Request<RegistrationRequestData> request) {
        //TODO
        RegistrationRequestData requestData = request.getData();
        userProfileService.register(requestData.getPhoneNumber(),requestData.getLocaleCode(),requestData.getDeviceId());

        RegistrationResponseData responseData = new RegistrationResponseData();
        responseData.setAuthCode("not set");
        responseData.setRegistrationRequestUuid("not set");
        responseData.setRegistrationTimeoutSec(-1);
        Response<RegistrationResponseData> response = new Response<RegistrationResponseData>();
        response.setHeader(request.getHeader());
        response.setData(responseData);
        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OFIGENNO !!!!");
        response.setStatus(status);

        return response;
    }
}
