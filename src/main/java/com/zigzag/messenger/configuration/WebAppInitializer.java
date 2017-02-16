package com.zigzag.messenger.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by zigza on 11.02.2017.
 */

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RestApplicationConfiguration.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfiguration.class};
    }

}
