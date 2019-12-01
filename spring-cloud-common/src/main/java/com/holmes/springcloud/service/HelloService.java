package com.holmes.springcloud.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {

    @GetMapping(value = "hello")
    String hello(@RequestParam("name") String name);
}
