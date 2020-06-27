package com.holmes.springcloud.order.service.impl;

import com.holmes.springcloud.order.entity.Order;
import com.holmes.springcloud.order.mapper.OrderMapper;
import com.holmes.springcloud.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Map<String, Object>> selectUserOrderList(Long userId) {
        return orderMapper.selectUserOrderList(userId);
    }

    @Override
    public List<Order> selectList() {
        return orderMapper.selectList();
    }

    @Override
    public List<Order> selectByUserId(Long userId) {
        return orderMapper.selectByUserId(userId);
    }

    @Override
    public int deleteById(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByUserId(Long userId) {
        return orderMapper.deleteByUserId(userId);
    }

    @Override
    public int insert(Order order) {
        order.setCreateTime(new Date());
        order.setModifyTime(new Date());
        return orderMapper.insert(order);
    }

    @Override
    public Order selectById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Order order) {
        order.setModifyTime(new Date());
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public int clearTable() {
        return orderMapper.clearTable();
    }
}
