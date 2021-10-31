package com.holmes.springcloud.ribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Random RANDOM = new Random();

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) throws Exception {

        log.info("hello: {}", name);
        if (RANDOM.nextInt(100) < 30) {
//            throw new Exception("发生了异常");
            log.info("接口执行超时");
            // 模拟超时
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        return "hello " + name;
    }
}
