package com.xxx.controller;

import com.xxx.entity.Response;
import com.xxx.entity.User;
import com.xxx.service.ConsumerService;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService service;


    @RequestMapping(value = "/addConsumer", method = RequestMethod.GET)
    public Response addUser() {
        int result = service.addConsumer();
        Response res = new Response();
        res.setMsg(result > 0 ? "添加成功" : "添加失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }
}
