package com.softgroup.frontend.controllers;

/**
 * Created by zigza on 25.02.2017.
 */

import com.softgroup.common.protocol.Request;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test",method= RequestMethod.GET)
public class TestController {
    @RequestMapping(path = "/")
    public String testMessage(@RequestBody final Request command) {
        return "test";
    }
}
