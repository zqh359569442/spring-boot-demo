package com.zqh.demo.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zqh.demo.common.entity.User;
import com.zqh.demo.dubboapi.UserService;
import com.zqh.demo.dubboprovider.mapper.UserRegistryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(timeout =  30000,group = "user",interfaceClass  = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRegistryMapper userRegistryMapper;

    @Override
    public User findUser(String id) {
        System.out.println(2222222);
        return userRegistryMapper.findUserById(Integer.valueOf(id));
    }


    public UserRegistryMapper getUserRegistryMapper() {
        return userRegistryMapper;
    }

    public void setUserRegistryMapper(UserRegistryMapper userRegistryMapper) {
        this.userRegistryMapper = userRegistryMapper;
    }
}
