package com.xxx.service;

import com.xxx.entity.Consumer;

import java.util.List;

public interface ConsumerService {
    int addConsumer(Consumer consumer);
    List<Consumer> queryById(int id);//查询客户
}
