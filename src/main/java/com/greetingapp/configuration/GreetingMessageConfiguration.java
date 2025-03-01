package com.greetingapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingMessageConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}