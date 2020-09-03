package com.xxx.controller;

import com.xxx.entity.Consumer;
import com.xxx.entity.Response;
import com.xxx.entity.User;
import com.xxx.service.ConsumerService;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<User> users = userService.queryById(consumer.getUser_id());
        if (users == null || users.size() == 0) {
            return new Response(-1, "账户校验失败，请重新登录");
        }

        int result = service.addConsumer(consumer);
        Response res = new Response();
        res.setMsg(result > 0 ? "添加成功" : "添加失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }

    //更新用户
    @RequestMapping("/updateConsumer")
    @ResponseBody
    public Response updateConsumer(@RequestBody Consumer consumer) {
        //判断关联账号是否存在
        List<User> users = userService.queryById(consumer.getUser_id());
        if (users == null || users.size() == 0) {
            return new Response(-1, "账户校验失败，请重新登录");
        }

        int result = service.updateConsumer(consumer);
        Response res = new Response();
        res.setMsg(result > 0 ? "修改成功" : "修改失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }

    //删除用户
    @RequestMapping("/delConsumer")
    @ResponseBody
    public Response delConsumer(int user_id, int consumer_id) {
        //判断关联账号是否存在
        List<User> users = userService.queryById(user_id);
        if (users == null || users.size() == 0) {
            return new Response(-1, "账户校验失败，请重新登录");
        }

        int result = service.delConsumer(user_id,consumer_id);
        Response res = new Response();
        res.setMsg(result > 0 ? "删除成功" : "删除失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }

    //获取客户列表
    @RequestMapping(value = "/getConsumerList", method = RequestMethod.POST)
    public Response getConsumerList(int user_id) {
        List<Consumer> consumers = service.queryByUserId(user_id);
        return new Response<List<Consumer>>(1, "获取成功", consumers);
    }
}
