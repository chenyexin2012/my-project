package com.holmes.springcloud.provider.service.impl;

import com.holmes.springcloud.entity.User;
import com.holmes.springcloud.provider.mapper.UserMapper;
import com.holmes.springcloud.provider.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteByPrimaryKey(id);
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
        return userMapper.clearTable();
    }
}
