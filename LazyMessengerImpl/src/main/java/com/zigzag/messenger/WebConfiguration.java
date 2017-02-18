package com.zigzag.messenger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zigza on 11.02.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan

public class WebConfiguration extends WebMvcConfigurerAdapter {

}
