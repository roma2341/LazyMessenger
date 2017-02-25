package com.zigzag.messenger.protocol.api.request;

import com.zigzag.messenger.protocol.api.Data;
import com.zigzag.messenger.protocol.api.RoutedAction;

/**
 * Created by zigza on 23.02.2017.
 */
public interface Request<T extends Data> extends RoutedAction<T> {
}
