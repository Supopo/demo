package com.xxx.service.impl;

import com.xxx.entity.Consumer;
import com.xxx.entity.User;
import com.xxx.mapper.ConsumerMapper;
import com.xxx.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public int addConsumer(Consumer consumer) {
        int result = consumerMapper.addConsumer(consumer);
        return result;
    }
}
