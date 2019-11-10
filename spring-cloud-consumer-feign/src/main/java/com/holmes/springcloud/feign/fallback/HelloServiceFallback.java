package com.holmes.springcloud.feign.fallback;

import com.holmes.springcloud.feign.service.HelloServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloServiceFeignClient {
    @Override
    public String hello(String name) {
        return null;
    }
}
