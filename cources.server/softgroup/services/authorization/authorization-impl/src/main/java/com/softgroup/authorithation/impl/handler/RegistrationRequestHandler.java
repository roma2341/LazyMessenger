package com.softgroup.authorithation.impl.handler;

import com.softgroup.common.cache.api.data.AuthorizationDetails;
import com.softgroup.common.cache.impl.service.AuthorizationDetailsCacheService;
import com.softgroup.common.database.model.UserProfile;
import com.softgroup.services.authorization.api.handler.AuthorizationHandler;
import com.softgroup.services.authorization.api.message.request.RegistrationRequestData;
import com.softgroup.services.authorization.api.message.response.RegistrationResponseData;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by zigza on 25.02.2017.
 */
@Component
public class RegistrationRequestHandler extends AbstractRequestHandler<RegistrationRequestData,RegistrationResponseData> implements AuthorizationHandler {
    @Autowired
    UserProfileService userProfileService;

    @Autowired
    AuthorizationDetailsCacheService authorizationDetailsCacheService;

    @Override
    public String getName() {
        return "register";
    }

    final int REGISTRATION_TIMEOUT_SEC = 15;

    public Response<RegistrationResponseData> process(Request<RegistrationRequestData> request) {
        //TODO get to know what must be returned in fields
        RegistrationRequestData requestData = request.getData();


        String registrationRequestUuid = UUID.randomUUID().toString();
        String authCode = UUID.randomUUID().toString();
        String phone = requestData.getPhoneNumber();
        String localeCode = requestData.getLocaleCode();
        String deviceId = requestData.getDeviceId();

       // UserProfile profile = userProfileService.register(phone,localeCode,deviceId);

        AuthorizationDetails authDetails = new AuthorizationDetails();
        authDetails.setDeviceId(deviceId);
        authDetails.setLocaleCode(localeCode);
        authDetails.setName("noname");
        authDetails.setPhoneNumber(phone);
        authDetails.setRegistrationRequestUuid(registrationRequestUuid);
        authDetails.setAuthCode(authCode);
        authorizationDetailsCacheService.put(authDetails);


        RegistrationResponseData responseData = new RegistrationResponseData();
        responseData.setAuthCode(authCode);
        responseData.setRegistrationRequestUuid(registrationRequestUuid);
        responseData.setRegistrationTimeoutSec(REGISTRATION_TIMEOUT_SEC);

        Response<RegistrationResponseData> response = new Response<RegistrationResponseData>();
        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);

        return response;
    }

}
