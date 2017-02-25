package com.zigzag.messenger.protocol.api.response;

import com.zigzag.messenger.protocol.api.response.data.ResponseData;
import com.zigzag.messenger.protocol.api.RoutedAction;

/**
 * Created by zigza on 23.02.2017.
 */
public interface Response<T extends ResponseData> extends RoutedAction<T> {
}
