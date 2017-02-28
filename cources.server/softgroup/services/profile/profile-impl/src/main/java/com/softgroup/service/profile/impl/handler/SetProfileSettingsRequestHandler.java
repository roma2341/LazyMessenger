package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.SetProfileSettingsRequestData;
import com.softgroup.services.profile.api.message.response.SetProfileSettingsResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class SetProfileSettingsRequestHandler extends AbstractRequestHandler<SetProfileSettingsRequestData,SetProfileSettingsResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public String getName() {
        return "set_profile_settings";
    }

    public Response<SetProfileSettingsResponseData> process(Request<SetProfileSettingsRequestData> request) {
        SetProfileSettingsRequestData requestData = request.getData();

        SetProfileSettingsResponseData responseData = new SetProfileSettingsResponseData();
        Response<SetProfileSettingsResponseData> response = new Response<SetProfileSettingsResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("Rock !!!!");
        response.setStatus(status);

        return response;
    }
}
