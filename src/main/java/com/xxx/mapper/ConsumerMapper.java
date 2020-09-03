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
    int updateConsumer(Consumer consumer);
    int delConsumer(int user_id, int consumer_id);
    List<Consumer> queryByUserId(int id);
    List<Consumer> queryById(int id);
}
