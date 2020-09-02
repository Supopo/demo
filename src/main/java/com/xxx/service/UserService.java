package com.xxx.service;

import com.xxx.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> queryByAccount(String account);//用于验证用户
}
