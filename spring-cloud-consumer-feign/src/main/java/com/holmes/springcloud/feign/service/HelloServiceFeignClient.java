package com.holmes.springcloud.feign.service;

import com.holmes.springcloud.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "springcloud-provider", fallback = HelloServiceFallback.class)
public interface HelloServiceFeignClient {

    @GetMapping(value = "hello")
    String hello(String name);
}
