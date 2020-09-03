package com.xxx.mapper;

import com.xxx.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    int addOrder(Order order);
    List<Order> queryById(int id);
    List<Order> queryAll(Order order);
}
