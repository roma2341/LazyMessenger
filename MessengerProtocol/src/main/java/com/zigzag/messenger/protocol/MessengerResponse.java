package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.response.data.ResponseData;

public class MessengerResponse<T extends ResponseData> extends MessengerRoutedAction<T> {
	private static final long serialVersionUID = 8979170551734666755L;

	private MessengerResponseStatus status;

	public MessengerResponseStatus getStatus() {
		return status;
	}

	public void setStatus(MessengerResponseStatus status) {
		this.status = status;
	}

}