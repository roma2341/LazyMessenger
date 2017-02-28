package com.softgroup.services.authorization.api.message.request;

import com.softgroup.common.protocol.RequestData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class LoginRequestData implements RequestData{

	private static final long serialVersionUID = 4895237867750981751L;

	private String deviceToken;

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}