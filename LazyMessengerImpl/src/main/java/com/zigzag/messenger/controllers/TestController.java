package com.zigzag.messenger.controllers;

/**
 * Created by zigza on 16.02.2017.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vi",
        method = RequestMethod.GET)
public class TestController {

    @RequestMapping(path = "/ka")
    public String rawText() {
        return "test";
    }
}
