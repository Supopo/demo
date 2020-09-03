package com.xxx.controller;

import com.xxx.entity.Consumer;
import com.xxx.entity.Order;
import com.xxx.entity.Response;
import com.xxx.service.ConsumerService;
import com.xxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Response addOrder(@RequestBody Order order) {
        if (order == null) {
            return new Response(0, "请求数据不能为空");
        }
        //判断关联客户是否存在
        List<Consumer> consumers = consumerService.queryById(order.getConsumer_id());
        if (consumers == null || consumers.size() == 0) {
            return new Response(-1, "客户不存在，查询失败");
        }

        int result = service.addOrder(order);
        Response res = new Response();
        res.setMsg(result > 0 ? "添加成功" : "添加失败");
        res.setStatus(result > 0 ? 1 : 0);
        return res;
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public Response getOrderList(int consumer_id) {
        List<Order> orders = service.queryById(consumer_id);
        return new Response<List<Order>>(1, "获取成功", orders);
    }

    @RequestMapping(value = "/queryAllOrder", method = RequestMethod.POST)
    public Response queryAllOrder(@RequestBody Order order) {
        List<Order> orders = service.queryAllOrder(order);
        return new Response<List<Order>>(1, "获取成功", orders);
    }
}
