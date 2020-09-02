package com.xxx.service.impl;

import com.xxx.entity.User;
import com.xxx.mapper.UserMapper;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        return result;
    }

    @Override
    public List<User> queryByAccount(String account) {
        List<User> userList = userMapper.queryByAccount(account);
        return userList;
    }

    @Override
    public List<User> queryById(int id) {
        List<User> userList = userMapper.queryById(id);
        return userList;
    }

}
