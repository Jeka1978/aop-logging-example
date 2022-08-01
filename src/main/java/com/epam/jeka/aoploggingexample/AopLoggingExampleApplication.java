package com.epam.jeka.aoploggingexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopLoggingExampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopLoggingExampleApplication.class, args);
        context.getBean(EpamService.class).doWork();
    }

}
