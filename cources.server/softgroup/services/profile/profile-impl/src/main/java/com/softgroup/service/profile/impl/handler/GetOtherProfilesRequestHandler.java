package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.GetOtherProfilesRequestData;
import com.softgroup.services.profile.api.message.response.GetOtherProfilesResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class GetOtherProfilesRequestHandler extends AbstractRequestHandler<GetOtherProfilesRequestData,GetOtherProfilesResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "get_other_profiles";
    }

    public Response<GetOtherProfilesResponseData> process(Request<GetOtherProfilesRequestData> request) {
        GetOtherProfilesRequestData requestData = request.getData();

        GetOtherProfilesResponseData responseData = new GetOtherProfilesResponseData();
        Response<GetOtherProfilesResponseData> response = new Response<GetOtherProfilesResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
