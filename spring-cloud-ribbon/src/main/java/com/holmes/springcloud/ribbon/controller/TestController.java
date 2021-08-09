package com.holmes.springcloud.ribbon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }
}
