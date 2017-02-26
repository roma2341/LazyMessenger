package com.softgroup.frontend.controllers;

/**
 * Created by zigza on 25.02.2017.
 */

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.dispatcher.DispatcherRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test",method= RequestMethod.GET)
public class TestController {
    @Autowired
    DispatcherRouter router;
    @RequestMapping(path = "/str")
    public String testMessage() {
        return "test";
    }

}
