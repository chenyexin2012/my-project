package com.holmes.springcloud.user.service;

import com.holmes.springcloud.user.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "order-service")
public interface OrderService {

    @GetMapping("/selectList")
    List<Order> selectList();

    @GetMapping("/selectByUserId")
    List<Order> selectByUserId(Long userId);

    @DeleteMapping("/delete/{id}")
    int deleteById(@PathVariable("id") Long id);

    @DeleteMapping("/deleteByUserId/{userId}")
    int deleteByUserId(@PathVariable("userId") Long userId);

    @PostMapping("/insert")
    int insert(Order order);

    @GetMapping("/selectById")
    Order selectById(Long id);

    @PostMapping("/update")
    int update(Order order);

    @GetMapping("/clear")
    int clearTable();
}
