package com.xxx.controller;

import com.xxx.entity.Response;
import com.xxx.entity.User;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserItem() {
        User user = service.getUserInfo();
        return user.toString();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public Response addUser() {
        int result = service.addUser();
        Response res = new Response();
        res.setMsg(result > 0 ? "添加成功" : "添加失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }
}
