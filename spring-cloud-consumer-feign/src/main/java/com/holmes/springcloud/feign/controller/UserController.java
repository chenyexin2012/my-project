package com.holmes.springcloud.feign.controller;

import com.holmes.springcloud.entity.User;
import com.holmes.springcloud.feign.service.HelloServiceFeignClient;
import com.holmes.springcloud.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserServiceFeign {

    @Autowired
    private HelloServiceFeignClient userService;

    @Override
    public List<User> selectList() {
        return userService.selectList();
    }

    @Override
    public int delete(Long id) {
        return userService.delete(id);
    }

    @Override
    public int insert(User user) {
        return userService.insert(user);
    }

    @Override
    public User selectById(Long id) {
        return userService.selectById(id);
    }

    @Override
    public int update(User user) {
        return userService.update(user);
    }

    @Override
    public int clearTable() {
        return userService.clearTable();
    }
}
