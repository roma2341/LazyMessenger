package com.softgroup.frontend.controllers;

/**
 * Created by zigza on 26.02.2017.
 */

import com.softgroup.common.datamapper.JacksonDataMapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zigza on 26.02.2017.
 */

        import org.springframework.web.bind.annotation.RestController;

        import com.softgroup.common.protocol.Request;
        import com.softgroup.common.protocol.Response;
        import com.softgroup.dispatcher.DispatcherRouter;
        import org.springframework.http.MediaType;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by zigza on 25.02.2017.
 */
@RestController
@RequestMapping(path = "/root",
        method = RequestMethod.POST)
public class RootController {
    @RequestMapping(path = "/router")
    public Response publicMessage(@RequestBody final String requestStr) {
        InputStream stream = new ByteArrayInputStream(requestStr.getBytes(StandardCharsets.UTF_8));
        JacksonDataMapper dataMapper = new JacksonDataMapper();
        Request request = dataMapper.readValue(stream,Request.class);
        DispatcherRouter dispatcher = new DispatcherRouter();
        return dispatcher.handle(request);
    }
}
