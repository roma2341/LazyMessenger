package com.softgroup.service.profile.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import org.springframework.stereotype.Component;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class ProfileRouter<T extends ProfileHandler> extends AbstractRouterHandler<T> implements CommonRouterHandler {

    public String getName() {
        return "profile";
    }
}