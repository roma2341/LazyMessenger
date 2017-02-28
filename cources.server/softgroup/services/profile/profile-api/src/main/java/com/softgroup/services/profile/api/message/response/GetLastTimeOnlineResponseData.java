package com.softgroup.services.profile.api.message.response;

import com.softgroup.common.database.model.UserProfileStatus;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by zigza on 28.02.2017.
 */
public class GetLastTimeOnlineResponseData implements ResponseData {
    List<UserProfileStatus> profiles;
}
