package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.LoginMapper;
import com.sunql.blog.service.impl.LoginServiceImpl;
import com.sunql.blog.service.impl.UserServiceImpl;
import com.sunql.blog.util.IpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
@CrossOrigin
@RestController
@Api(tags ={"1-1 用户管理"})
@RequestMapping("/blog/user")
public class UserController extends BaseController {
    @Autowired
    private UserServiceImpl userService;


    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public RespEntity login(@RequestParam("userPhone") String userPhone, @RequestParam("userPwd") String userPwd){
        //String ipaddress= IpUtil.getIpAddr(request);
        User user= userService.onLogin(userPhone,userPwd,"192.168.1.1");

        if (user!=null){
            return new RespEntity(RespCode.SUCCESS,user);
        }else{
            return new RespEntity(RespCode.WARN,"登陆失败");
        }

    }
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public  RespEntity register(User user){
        User reultUser=userService.onRegister(user);
       if(reultUser!=null) {
           return new RespEntity(RespCode.SUCCESS,reultUser);
       }else{
           return new RespEntity(RespCode.WARN,"注册失败");
       }

    }

}
