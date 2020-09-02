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
    public int addConsumer() {
        Consumer user = new Consumer();
        user.setName("阿凡提2");
        user.setMobile("18812345678");
        user.setAddress("新疆买买提");
        user.setRemark("十头羊");
        int result = consumerMapper.addConsumer(user);
        return result;
    }
}
