package com.exmple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    public String hello() {
        return "hello Test";
    }
}
