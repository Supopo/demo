package com.xxx.service.impl;

import com.xxx.entity.Consumer;
import com.xxx.entity.User;
import com.xxx.mapper.ConsumerMapper;
import com.xxx.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public int addConsumer(Consumer consumer) {
        int result = consumerMapper.addConsumer(consumer);
        return result;
    }

    @Override
    public List<Consumer> queryByUserId(int id) {
        List<Consumer> consumerList = consumerMapper.queryByUserId(id);
        return consumerList;
    }

    @Override
    public List<Consumer> queryById(int id) {
        List<Consumer> consumerList = consumerMapper.queryById(id);
        return consumerList;
    }
}
