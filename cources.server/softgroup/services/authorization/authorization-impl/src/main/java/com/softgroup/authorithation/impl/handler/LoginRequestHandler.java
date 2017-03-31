package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorithation.impl.services.TokenService;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.authorization.api.handler.AuthorizationHandler;
import com.softgroup.services.authorization.api.message.request.LoginRequestData;
import com.softgroup.services.authorization.api.message.response.LoginResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by zigza on 03.03.2017.
 */
@Component
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequestData,LoginResponseData> implements AuthorizationHandler {
    @Autowired
    TokenService tokenService;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponseData> process(Request<LoginRequestData> request) {
        //TODO get to know what must be returned in fields
        LoginRequestData requestData = request.getData();

        LoginResponseData responseData = new LoginResponseData();

        Response<LoginResponseData> response = new Response<LoginResponseData>();

        ActionHeader requestHeader = request.getHeader();

        String deviceToken = requestData.getDeviceToken();
        String token = tokenService.generateTokenByDeviceToken(deviceToken);
        responseData.setToken(token);

        ActionHeader responseHeader = new ActionHeader();
        responseHeader.setCommand(requestHeader.getCommand());
        responseHeader.setType(requestHeader.getType());
        responseHeader.setOriginUuid(requestHeader.getUuid());


        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);

        return response;
    }


    
}
