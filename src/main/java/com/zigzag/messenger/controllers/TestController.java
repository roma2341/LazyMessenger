package com.zigzag.messenger.controllers;

/**
 * Created by zigza on 16.02.2017.
 */
import com.zigzag.messanger.Model.UserMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test",
        method = RequestMethod.GET)
public class TestController {

    @RequestMapping(path = "/message")
    public UserMessage publicMessage() {
        return new UserMessage();
    }
}