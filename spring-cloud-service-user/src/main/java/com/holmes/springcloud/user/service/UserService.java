package com.holmes.springcloud.user.service;

import com.holmes.springcloud.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> selectList();

    int deleteById(Long id);

    int insert(User user);

    User selectById(Long id);

    int update(User user);

    int clearTable();
}
