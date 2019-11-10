package com.holmes.springcloud.feign.service;

import com.holmes.springcloud.feign.fallback.HelloServiceFallback;
import com.holmes.springcloud.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider", fallback = HelloServiceFallback.class)
public interface HelloServiceFeignClient extends HelloService {
}
