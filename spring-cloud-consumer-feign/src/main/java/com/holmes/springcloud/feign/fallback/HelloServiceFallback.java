package com.holmes.springcloud.feign.fallback;

import com.holmes.springcloud.entity.User;
import com.holmes.springcloud.feign.service.HelloServiceFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HelloServiceFallback implements HelloServiceFeignClient {

//    @Override
//    public String hello(String name) {
//        return null;
//    }

    @Override
    public List<User> selectList() {
        return new ArrayList<>();
    }

    @Override
    public int delete(Long id) {
        return -1;
    }

    @Override
    public int insert(User user) {
        return -1;
    }

    @Override
    public User selectById(Long id) {
        return null;
    }

    @Override
    public int update(User user) {
        return -1;
    }

    @Override
    public int clearTable() {
        return -1;
    }
}
