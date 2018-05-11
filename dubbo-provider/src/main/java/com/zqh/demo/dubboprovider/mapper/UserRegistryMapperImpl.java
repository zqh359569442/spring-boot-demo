package com.zqh.demo.dubboprovider.mapper;

import com.zqh.demo.common.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistryMapperImpl implements UserRegistryMapper {
    @Override
    public User findUserById(int id) {
        User user = new User();
        user.setId(1);
        user.setSex("男");
        user.setAge(25);
        user.setDescriptor("傻逼");

        return user;
    }
}
