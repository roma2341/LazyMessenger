package com.softgroup.frontend.controllers;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.dispatcher.DispatcherRouter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zigza on 25.02.2017.
 */
@RestController
@RequestMapping(path = "/conversations",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {
 @RequestMapping(path = "/")
    public Response publicMessage(@RequestBody final Request command) {
     DispatcherRouter dispatcher = new DispatcherRouter();
     return dispatcher.handle(command);
    }
}
