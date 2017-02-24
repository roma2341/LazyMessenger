package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.Data;
import com.zigzag.messenger.protocol.api.ResponseData;

import java.io.Serializable;

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
