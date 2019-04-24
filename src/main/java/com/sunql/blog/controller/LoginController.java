package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.base.ServiceException;
import com.sunql.blog.entity.Login;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.impl.LoginServiceImpl;
import com.sunql.blog.service.impl.UserServiceImpl;
import com.sunql.blog.util.MD5;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
@CrossOrigin
@RestController
@Api(tags ={"1-5 登陆管理"})
@RequestMapping("/blog/login")
public class LoginController extends BaseController {
    @Autowired
    private LoginServiceImpl loginService;
    /**
     * 退出登陆
     *
     * @param uid
     * @return
     */
    @PostMapping(value = "/outlogin")
    public RespEntity outlogin(@RequestParam("userPhone")String uid){
        if (loginService.onExitLogin(uid)){
            return new RespEntity(RespCode.SUCCESS,"退出成功");
        }else{
            return new RespEntity(RespCode.WARN,"请求失败");
        }
    }
}
