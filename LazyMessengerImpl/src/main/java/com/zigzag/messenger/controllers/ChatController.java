package com.zigzag.messenger.controllers;

import com.zigzag.messenger.API.domain.CommandRequest;
import com.zigzag.messenger.API.domain.CommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zigza on 19.02.2017.
 */
@RestController
@RequestMapping(path = "/contacts",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {

    @RequestMapping(path = "/")
    public CommandResponse publicMessage(@RequestBody final CommandRequest command) {
        return command.process();
    }
}
