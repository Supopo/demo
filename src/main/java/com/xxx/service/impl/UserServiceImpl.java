package com.xxx.service.impl;

import com.xxx.entity.User;
import com.xxx.mapper.UserMapper;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo() {
        User user = new User();
        user.setName("阿凡提");
        user.setAddress("新疆买买提");
        return user;
    }

    public int addUser() {
        User user = new User();
        user.setName("阿凡提");
        user.setMobile("18812345678");
        user.setAddress("新疆买买提");
        user.setRemark("十头羊");
        int result = userMapper.addUser(user);
        return result;
    }
}
