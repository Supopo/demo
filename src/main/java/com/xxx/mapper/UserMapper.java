package com.xxx.mapper;

import com.xxx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    int addUser(User user);

    List<User> queryByAccount(String account);
    List<User> queryById(int id);
}
