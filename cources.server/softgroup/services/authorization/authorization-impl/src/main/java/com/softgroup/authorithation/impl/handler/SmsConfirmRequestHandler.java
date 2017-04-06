package com.softgroup.authorithation.impl.handler;

import com.softgroup.common.cache.api.data.RegistrationRequestDetails;
import com.softgroup.common.cache.impl.service.RegistrationRequestDetailsCacheService;
import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.token.api.services.TokenService;
import com.softgroup.services.authorization.api.handler.AuthorizationHandler;
import com.softgroup.services.authorization.api.message.request.SmsConfirmRequestData;
import com.softgroup.services.authorization.api.message.response.SmsConfirmResponseData;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class SmsConfirmRequestHandler  extends AbstractRequestHandler<SmsConfirmRequestData,SmsConfirmResponseData> implements AuthorizationHandler {
    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Autowired
    RegistrationRequestDetailsCacheService registrationRequestDetailsCacheService;

    static Logger log = LoggerFactory.getLogger(SmsConfirmRequestHandler.class);

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    TokenService tokenService;

    @Override
    public Response<SmsConfirmResponseData> process(Request<SmsConfirmRequestData> request) {
        Response<SmsConfirmResponseData> response = new Response<SmsConfirmResponseData>();
        response.setHeader(request.getHeader());
        SmsConfirmResponseData responseData = new  SmsConfirmResponseData();

        String registrationRequestUUID = request.getData().getRegistrationRequestUuid();
        RegistrationRequestDetails details = null;
        try {
            details = registrationRequestDetailsCacheService.get(registrationRequestUUID);
        }
        catch (ExecutionException e){
            e.printStackTrace();
            ResponseStatus status = new ResponseStatus();
            status.setCode(422);
            response.setStatus(status);
            return response;
        }
        String receivedAuthCode = request.getData().getAuthCode();
        String requiredAuthCode = details.getAuthCode();
        if (!receivedAuthCode.equals(requiredAuthCode)){
            ResponseStatus status = new ResponseStatus();
            status.setCode(422);
            response.setStatus(status);
            return response;
        }

        UserProfile profile = userProfileService.register(details.getPhoneNumber(),details.getLocaleCode(),details.getDeviceId());
        String deviceToken = tokenService.generateDeviceToken(profile.getId(),details.getDeviceId(),profile.getName(),profile.getPhoneNumber());

        responseData.setDeviceToken(deviceToken);
        response.setData(responseData);
        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);
        return response;
    }
}
