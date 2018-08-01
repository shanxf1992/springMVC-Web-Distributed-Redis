package com.itheima.mapper;

import com.itheima.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {

    public void register(User user);
}
