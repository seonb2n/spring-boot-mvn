package com.exmple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class SampleProperties {
    @Value("${key}")
    private String key;
}
