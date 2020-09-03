package com.xxx.service.impl;

import com.xxx.entity.Order;
import com.xxx.mapper.OrderMapper;
import com.xxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        int result = orderMapper.addOrder(order);
        return result;
    }

    @Override
    public List<Order> queryById(int id) {
        List<Order> orderList = orderMapper.queryById(id);
        return orderList;
    }

    @Override
    public List<Order> queryAllOrder(Order order) {
        List<Order> orderList = orderMapper.queryAll(order);
        return orderList;
    }
}
