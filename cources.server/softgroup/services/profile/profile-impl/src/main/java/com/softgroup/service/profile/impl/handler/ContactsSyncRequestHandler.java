package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.ContactsSyncRequestData;
import com.softgroup.services.profile.api.message.response.ContactsSyncResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class ContactsSyncRequestHandler extends AbstractRequestHandler<ContactsSyncRequestData,ContactsSyncResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "contacts_sync";
    }

    public Response<ContactsSyncResponseData> process(Request<ContactsSyncRequestData> request) {
        ContactsSyncRequestData requestData = request.getData();

        ContactsSyncResponseData responseData = new ContactsSyncResponseData();
        Response<ContactsSyncResponseData> response = new Response<ContactsSyncResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
