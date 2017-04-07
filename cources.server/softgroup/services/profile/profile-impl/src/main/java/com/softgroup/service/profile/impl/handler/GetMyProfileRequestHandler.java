package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.model.UserProfile;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.UserProfilePrincipal;
import com.softgroup.dto.entities.UserProfileDTO;
import com.softgroup.dto.services.DTOMapper;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.GetMyProfileRequestData;
import com.softgroup.services.profile.api.message.response.GetMyProfileResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class GetMyProfileRequestHandler extends AbstractRequestHandler<GetMyProfileRequestData,GetMyProfileResponseData> implements ProfileHandler {
    @Autowired
    UserProfileService userProfileService;


    @Autowired
    DTOMapper dtoMapper;

    @Override
    public String getName() {
        return "get_my_profile";
    }

    public Response<GetMyProfileResponseData> process(Request<GetMyProfileRequestData> request) {
        GetMyProfileRequestData requestData = request.getData();

        GetMyProfileResponseData responseData = new GetMyProfileResponseData();
        UserProfilePrincipal principal = (UserProfilePrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       UserProfile profile =  userProfileService.getProfile(principal.getUserId());
        UserProfileDTO profileDTO = dtoMapper.map(profile);
        responseData.setProfile(profileDTO);

        Response<GetMyProfileResponseData> response = new Response<GetMyProfileResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);

        return response;
    }
}
