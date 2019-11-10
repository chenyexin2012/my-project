package com.holmes.springcloud.provider.controller;

import com.holmes.springcloud.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloService {

    @GetMapping(value = "hello")
    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }
}
