package com.softgroup.dto.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zigza on 06.04.2017.
 */
@ComponentScan(basePackages = {"com.softgroup"})
@Configuration
public class ModelMapperConfiguration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
