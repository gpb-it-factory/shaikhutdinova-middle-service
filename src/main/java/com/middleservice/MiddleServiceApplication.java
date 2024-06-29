package com.middleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserApiConfig.class)

@SpringBootApplication
public class

MiddleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddleServiceApplication.class, args);
    }
}
