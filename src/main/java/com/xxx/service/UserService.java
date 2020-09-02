package com.xxx.service;

import com.xxx.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);//用于注册账户
    List<User> queryByAccount(String account);//查询用户，用于验证用户信息
    List<User> queryById(int id);//查询用户，用于验证用户信息
}
