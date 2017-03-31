package com.softgroup.common.protocol;

import java.io.Serializable;

public class RoutedAction<T extends Serializable> extends Action<T> {
	private static final long serialVersionUID = -318012176965757271L;

	public RoutedData getRoutedData() {
		return routedData;
	}

	public void setRoutedData(RoutedData routedData) {
		this.routedData = routedData;
	}

	private RoutedData routedData;

}
