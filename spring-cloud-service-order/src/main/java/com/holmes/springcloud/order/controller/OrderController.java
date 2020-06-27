package com.holmes.springcloud.order.controller;

import com.holmes.springcloud.order.entity.Order;
import com.holmes.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/selectList")
    public List<Order> selectList() {
        return orderService.selectList();
    }

    @GetMapping("/selectByUserId")
    public List<Order> selectByUserId(Long userId) {
        return orderService.selectByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteById(@PathVariable("id") Long id) {
        return orderService.deleteById(id);
    }

    @DeleteMapping("/deleteByUserId/{userId}")
    public int deleteByUserId(@PathVariable("userId") Long userId) {
        return orderService.deleteByUserId(userId);
    }

    @PostMapping("/insert")
    public int insert(Order order) {
        return orderService.insert(order);
    }

    @GetMapping("/selectById")
    public Order selectById(Long id) {
        return orderService.selectById(id);
    }

    @PostMapping("/update")
    public int update(Order order) {
        return orderService.update(order);
    }

    @GetMapping("/clear")
    public int clearTable() {
        return orderService.clearTable();
    }
}
