package com.softgroup.frontend.security;

import com.softgroup.common.database.model.UserDevice;
import com.softgroup.common.database.services.UserDeviceService;
import com.softgroup.common.protocol.RoutedData;
import com.softgroup.common.token.api.services.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zigza on 31.03.2017.
 */
@Component
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    static Logger log = LoggerFactory.getLogger(TokenAuthenticationFilter.class);
    final String TOKEN_HEADER_NAME = "x-token";
    final String ROUTED_DATA_HEADER_NAME = "routed_data";

    @Autowired
    TokenAuthentication tokenAuthentication;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserDeviceService deviceService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("filtering request");
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader(TOKEN_HEADER_NAME);
        String deviceId = tokenService.getDeviceId(token);

        UserDevice userDevice = deviceService.findUserDeviceById(deviceId);


        if (userDevice.getUpdateDateTime().equals(tokenService.getCreationTime(token)) ) {
            RoutedData routedData = new RoutedData();
            request.getSession().setAttribute(ROUTED_DATA_HEADER_NAME, generateRoutedData(
                    request.getHeader(TOKEN_HEADER_NAME)));
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
            chain.doFilter(req, res);
            log.info("Request status: OK");
        } else {
            ((HttpServletResponse) res).sendError(403);
            log.error("Request status: ERROR 403");
        }
    }

    private RoutedData generateRoutedData(String token) {
        RoutedData routedData = new RoutedData();
        routedData.setDeviceId(tokenService.getDeviceId(token));
        routedData.setUserId(tokenService.getUserId(token));
        return routedData;
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
