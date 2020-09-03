package com.xxx.service;

import com.xxx.entity.Order;

import java.util.List;

public interface OrderService {
    int addOrder(Order order);

    List<Order> queryById(int id);

    List<Order> queryAllOrder(Order order);
}
