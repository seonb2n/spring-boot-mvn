package com.exmple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Autowired
    private String hello;

    @Autowired
    private SampleProperties sampleProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("======================");
        logger.info(sampleProperties.getName());
        logger.info(sampleProperties.getFullName());
        System.out.println("======================");

    }
}
