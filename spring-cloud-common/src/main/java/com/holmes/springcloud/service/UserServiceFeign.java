package com.holmes.springcloud.service;

import com.holmes.springcloud.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserServiceFeign {

    @GetMapping("/getUserList")
    List<User> selectList();

    @DeleteMapping("/delete/{id}")
    int delete(@PathVariable("id") Long id);

    @PostMapping("/insert")
    int insert(@RequestBody User user);

    @GetMapping("/selectById")
    User selectById(Long id);

    @PostMapping("/update")
    int update(@RequestBody User user);

    @GetMapping("/clear")
    int clearTable();
}
