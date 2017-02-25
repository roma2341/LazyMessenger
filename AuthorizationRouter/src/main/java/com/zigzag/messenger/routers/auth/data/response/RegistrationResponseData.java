package com.zigzag.messenger.routers.auth.data.response;

import com.zigzag.messenger.protocol.api.response.data.ResponseData;

/**
 * Created by zigza on 25.02.2017.
 */
public class RegistrationResponseData implements ResponseData {
    private String registrationRequestUuid;
    private Long registrationTimeoutSec;
    private String authCode;
}
