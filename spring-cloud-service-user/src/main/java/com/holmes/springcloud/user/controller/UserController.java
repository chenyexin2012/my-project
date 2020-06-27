package com.holmes.springcloud.user.controller;

import com.holmes.springcloud.user.entity.User;
import com.holmes.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public List<User> selectList() {
        return userService.selectList();
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

    @PostMapping("/insert")
    public int insert(User user) {
        return userService.insert(user);
    }

    @GetMapping("/getUserById")
    public User getUserById(Long id) {
        return userService.selectById(id);
    }

    @PostMapping("/update")
    public int update(User user) {
        return userService.update(user);
    }

    @GetMapping("/clear")
    public int clearTable() {
        return userService.clearTable();
    }
}
