package com.softgroup.frontend.controllers;

/**
 * Created by zigza on 26.02.2017.
 */

import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zigza on 26.02.2017.
 */

        import org.springframework.web.bind.annotation.RestController;

import com.softgroup.dispatcher.DispatcherRouter;
        import org.springframework.http.MediaType;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zigza on 25.02.2017.
 */
@RestController
@RequestMapping(path = "/messenger",
        method = RequestMethod.POST)
public class RootController {
    final String ROUTED_DATA_PARAM_NAME = "routed_data";

    @Autowired
    DispatcherRouter dispatcher;

    @Autowired
    JacksonDataMapper dataMapper;

    @RequestMapping(path = "/public")
    public Response publicRequestMapper(@RequestBody final CommonRequest request) {
        return processRequest(request);
    }
    @RequestMapping(path = "/private")
    public Response privateRequestMapper(@RequestBody final CommonRequest request,HttpSession session) {
        request.setRoutedData((RoutedData)session.getAttribute(ROUTED_DATA_PARAM_NAME));
        return processRequest(request);
    }
    private Response processRequest(Request request){
        return dispatcher.handle(request);
    }
}
