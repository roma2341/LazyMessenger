package com.softgroup.frontend.security;

import com.softgroup.common.database.model.UserDevice;
import com.softgroup.common.database.services.UserDeviceService;
import com.softgroup.common.protocol.RoutedData;
import com.softgroup.common.router.api.UserProfilePrincipal;
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
import java.util.Date;

/**
 * Created by zigza on 31.03.2017.
 */
@Component
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    static Logger log = LoggerFactory.getLogger(TokenAuthenticationFilter.class);
    final String TOKEN_HEADER_NAME = "token";
    final String ROUTED_DATA_HEADER_NAME = "routed_data";

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
        String userId = tokenService.getUserId(token);
        String name = tokenService.getName(token);
        String phone = tokenService.getPhone(token);

        Date expiredDate = new Date(tokenService.getExpirationTime(token));
        if (expiredDate.after(new Date())) {
            RoutedData routedData = new RoutedData();
            request.getSession().setAttribute(ROUTED_DATA_HEADER_NAME, generateRoutedData(
                    request.getHeader(TOKEN_HEADER_NAME)));
            UserProfilePrincipal userPrinciple = new UserProfilePrincipal();
            userPrinciple.setUserId(userId);
            userPrinciple.setDeviceId(deviceId);
            userPrinciple.setName(name);
            userPrinciple.setPhoneNumber(phone);

            TokenAuthentication tokenAuthentication = new TokenAuthentication(userPrinciple);
            TokenAuthenticationDetails authDetails = new TokenAuthenticationDetails();
            authDetails.setDeviceId(deviceId);
            //tokenAuthentication.setDetails(authDetails);
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
            log.info("Request status: OK");
        } else {
            ((HttpServletResponse) res).sendError(403);
            log.error("Request status: ERROR 403");
        }
        chain.doFilter(req, res);
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
