package com.holmes.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSpringApplication.class, args);
    }
}
