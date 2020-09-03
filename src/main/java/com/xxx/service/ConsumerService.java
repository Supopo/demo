package com.xxx.service;

import com.xxx.entity.Consumer;

import java.util.List;

public interface ConsumerService {
    int addConsumer(Consumer consumer);
    int updateConsumer(Consumer consumer);
    int delConsumer(int user_id, int consumer_id);
    List<Consumer> queryByUserId(int user_id);//查询用户的客户列表
    List<Consumer> queryById(int id);//查询客户
}
