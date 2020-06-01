package com.hyving.ocean.controller;

import com.hyving.ocean.model.request.UserAddReq;
import com.hyving.ocean.model.request.IdReq;
import com.hyving.ocean.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Hyving 黄瀚
 * @date: 2020/6/1
 * han.huang@sioeye.com
 * Chengdu Tianfu Software Park
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserAddReq req){
        return userService.addUser(req);
    }
    @PostMapping("/get-info")
    public String getInfo(@RequestBody IdReq req){
        return userService.getUserInfo(req);
    }



}
