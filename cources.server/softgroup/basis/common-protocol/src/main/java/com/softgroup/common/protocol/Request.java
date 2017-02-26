package com.softgroup.common.protocol;

import java.io.Serializable;

public class Request<T extends RequestData> extends RoutedAction<T> {
	private static final long serialVersionUID = -1024761631293962969L;
	String command;
}
