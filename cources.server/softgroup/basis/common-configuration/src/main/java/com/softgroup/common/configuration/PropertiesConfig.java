package com.softgroup.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;


/**
 * Created by zigza on 20.02.2017.
 */
@Component
public class PropertiesConfig {
    static @Bean public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
    }
}

