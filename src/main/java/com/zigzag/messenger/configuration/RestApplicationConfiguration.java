package com.zigzag.messenger.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by zigza on 16.02.2017.
 */
@Configuration
@ComponentScan(basePackages = "com.zigzag.messenger",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class RestApplicationConfiguration {


}
