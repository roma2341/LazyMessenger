package com.softgroup.frontend.configurator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zigza on 11.02.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.softgroup"})

public class WebConfiguration extends WebMvcConfigurerAdapter {

}
