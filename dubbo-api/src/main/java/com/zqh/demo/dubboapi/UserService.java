package com.zqh.demo.dubboapi;

import com.zqh.demo.common.entity.User;

public interface UserService {

    User findUser(String id);
}

