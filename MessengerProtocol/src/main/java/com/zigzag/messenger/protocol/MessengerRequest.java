package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.Data;
import com.zigzag.messenger.protocol.api.RequestData;

import java.io.Serializable;

public class MessengerRequest<T extends RequestData> extends MessengerRoutedAction<T> {
	private static final long serialVersionUID = -1024761631293962969L;
}
