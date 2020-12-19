package com.zyn.controller;

import com.zyn.entity.User;
import com.zyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 赵亚楠
 * @create 2020/11/5 10:30
 * @Description
 */
@RestController
public class TestController {

    @Autowired
    UserService userService;
//    @Autowired
//    CompanyUserBatchServiceImpl service;


    //D:\txt
    @GetMapping("/liuManRenameFile")
    public String test02(@RequestParam("dir") String dir) {



        return "success";
    }
    @GetMapping("/user")
    public User test01() {

        User user = new User();
        user.setId(222);
        user.setName("zyn");
        user.setAge("12");


        return user;
    }


}
