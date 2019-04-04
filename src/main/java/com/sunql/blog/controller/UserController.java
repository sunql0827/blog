package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.User;
import com.sunql.blog.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
@RestController
@Api(tags ={"1-1 用户管理"})
@RequestMapping("/blog/user")
public class UserController extends BaseController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public RespEntity login(@RequestParam("userPhone") String userPhone, @RequestParam("userPwd") String userPwd){
        User user= userService.onLogin(userPhone,userPwd);
        return new RespEntity(RespCode.SUCCESS,user);
    }
}
