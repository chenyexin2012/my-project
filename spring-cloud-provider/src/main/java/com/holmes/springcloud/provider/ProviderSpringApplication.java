package com.holmes.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderSpringApplication.class, args);
    }
}
