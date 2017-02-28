package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.ContactsSyncRequestData;
import com.softgroup.services.profile.api.message.request.GetContactProfilesRequestData;
import com.softgroup.services.profile.api.message.response.ContactsSyncResponseData;
import com.softgroup.services.profile.api.message.response.GetContactProfilesResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class GetContactProfilesRequestHandler extends AbstractRequestHandler<GetContactProfilesRequestData,GetContactProfilesResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "get_contact_profiles";
    }

    public Response<GetContactProfilesResponseData> process(Request<GetContactProfilesRequestData> request) {
        GetContactProfilesRequestData requestData = request.getData();

        GetContactProfilesResponseData responseData = new GetContactProfilesResponseData();
        Response<GetContactProfilesResponseData> response = new Response<GetContactProfilesResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
