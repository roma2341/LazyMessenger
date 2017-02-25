package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegistrationRequestData;
import com.softgroup.authorization.api.message.RegistrationResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Created by zigza on 25.02.2017.
 */
public class RegistrationRequestHandler extends AbstractRequestHandler<RegistrationRequestData,RegistrationResponseData> implements AuthorizationRequestHandler {
    public Response<RegistrationResponseData> process(Request<RegistrationRequestData> request) {
        //TODO
    return null;
    }
}
