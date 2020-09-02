package com.xxx.controller;

import com.xxx.entity.Consumer;
import com.xxx.entity.Response;
import com.xxx.entity.User;
import com.xxx.service.ConsumerService;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService service;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addConsumer", method = RequestMethod.POST)
    public Response addConsumer(@RequestBody Consumer consumer) {
        if (consumer == null) {
            return new Response(0, "请求数据不能为空");
        }
        //判断关联账号是否存在
        List<User> users = userService.queryById(consumer.getParent_id());
        if (users == null || users.size() == 0) {
            return new Response(-1, "账户校验失败，请重新登录");
        }

        int result = service.addConsumer(consumer);
        Response res = new Response();
        res.setMsg(result > 0 ? "添加成功" : "添加失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }
}
