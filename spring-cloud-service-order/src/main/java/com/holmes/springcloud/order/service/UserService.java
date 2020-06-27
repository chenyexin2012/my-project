package com.holmes.springcloud.order.service;

import com.holmes.springcloud.order.entity.User;
import com.holmes.springcloud.order.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/getUserList")
    List<User> selectList();

    @DeleteMapping("/delete/{id}")
    int delete(@PathVariable("id") Long id);

    @PostMapping("/insert")
    int insert(@RequestBody User user);

    @GetMapping("/getUserById")
    User getUserById(Long id);

    @PostMapping("/update")
    int update(@RequestBody User user);

    @GetMapping("/clear")
    int clearTable();
}
