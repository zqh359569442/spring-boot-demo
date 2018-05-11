package com.zqh.demo.dubbocustomer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zqh.demo.common.entity.User;
import com.zqh.demo.dubboapi.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class TestController {
    @Reference(timeout = 30000,group = "user")
    private UserService userService;
    @GetMapping("/test/{id}")
    @ResponseBody
    public User findUser(@PathVariable String id){
            System.out.println(1111111111);

            return userService.findUser(id);
    }


  /*  public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
}
