package com.xxx.controller;

import com.xxx.entity.Response;
import com.xxx.entity.User;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody User user) {
        //1.判断账户、密码是否为空
        if (user == null) {
            return new Response(0, "请求数据不能为空");
        }
        if (user.getAccount() == null || user.getAccount().equals("")) {
            return new Response(0, "账号不能为空");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            return new Response(0, "密码不能为空");
        }
        //2.判断是否存在
        List<User> users = service.queryByAccount(user.getAccount());
        if (users != null && users.size() > 0) {
            return new Response(0, "注册失败，账号已存在");
        } else {
            int count = service.addUser(user);
            if (count > 0) {
                //3.没有重复用户名，注册成功
                return new Response(1, "注册成功");
            } else {
                return new Response(0, "注册失败");
            }
        }
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody User user) {
        //1.判断账户、密码是否为空
        if (user == null) {
            return new Response(0, "请求数据不能为空");
        }
        if (user.getAccount() == null || user.getAccount().equals("")) {
            return new Response(0, "账号不能为空");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            return new Response(0, "密码不能为空");
        }
        //2.判断是否存在
        List<User> users = service.queryByAccount(user.getAccount());
        if (users == null || users.size() == 0) {
            return new Response(0, "账号不存在");
        } else {
            User userInfo = users.get(0);
            //3.判断密码是否一致
            if (userInfo.getPassword().equals(user.getPassword())) {
                return new Response<User>(1, "登录成功", userInfo);
            }
            return new Response(0, "登录失败，密码错误");
        }
    }
}
