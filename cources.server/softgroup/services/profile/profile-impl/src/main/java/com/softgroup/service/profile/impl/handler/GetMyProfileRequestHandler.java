package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.GetMyProfileRequestData;
import com.softgroup.services.profile.api.message.response.GetMyProfileResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class GetMyProfileRequestHandler extends AbstractRequestHandler<GetMyProfileRequestData,GetMyProfileResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "get_my_profile";
    }

    public Response<GetMyProfileResponseData> process(Request<GetMyProfileRequestData> request) {
        GetMyProfileRequestData requestData = request.getData();

        GetMyProfileResponseData responseData = new GetMyProfileResponseData();
        Response<GetMyProfileResponseData> response = new Response<GetMyProfileResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
