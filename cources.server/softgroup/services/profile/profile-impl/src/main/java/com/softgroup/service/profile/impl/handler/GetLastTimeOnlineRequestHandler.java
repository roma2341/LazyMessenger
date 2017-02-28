package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.GetLastTimeOnlineRequestData;
import com.softgroup.services.profile.api.message.response.GetLastTimeOnlineResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class GetLastTimeOnlineRequestHandler extends AbstractRequestHandler<GetLastTimeOnlineRequestData,GetLastTimeOnlineResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "get_last_time_online";
    }

    public Response<GetLastTimeOnlineResponseData> process(Request<GetLastTimeOnlineRequestData> request) {
        GetLastTimeOnlineRequestData requestData = request.getData();

        GetLastTimeOnlineResponseData responseData = new GetLastTimeOnlineResponseData();
        Response<GetLastTimeOnlineResponseData> response = new Response<GetLastTimeOnlineResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
