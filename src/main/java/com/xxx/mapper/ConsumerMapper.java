package com.xxx.mapper;

import com.xxx.entity.Consumer;
import com.xxx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConsumerMapper {
    int addConsumer(Consumer user);
    List<Consumer> queryById(int id);
}
