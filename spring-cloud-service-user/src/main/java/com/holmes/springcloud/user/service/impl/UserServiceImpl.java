package com.holmes.springcloud.user.service.impl;

import com.holmes.springcloud.user.entity.User;
import com.holmes.springcloud.user.mapper.UserMapper;
import com.holmes.springcloud.user.service.OrderService;
import com.holmes.springcloud.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderService orderService;

    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }

    @Override
    public int deleteById(Long id) {
        int result = userMapper.deleteByPrimaryKey(id);
        // 按用户id删除订单信息
        orderService.deleteByUserId(id);
        return result;
    }

    @Override
    public int insert(User record) {
        record.setCreateTime(new Date());
        record.setModifyTime(new Date());
        return userMapper.insert(record);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(User record) {
        record.setModifyTime(new Date());
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int clearTable() {
        userMapper.clearTable();
        orderService.clearTable();
        return 1;
    }
}
