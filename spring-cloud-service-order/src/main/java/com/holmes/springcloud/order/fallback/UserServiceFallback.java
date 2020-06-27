package com.holmes.springcloud.order.fallback;

import com.holmes.springcloud.order.entity.User;
import com.holmes.springcloud.order.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceFallback implements UserService {

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
        return 0;
    }

    @Override
    public User getUserById(Long id) {
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
