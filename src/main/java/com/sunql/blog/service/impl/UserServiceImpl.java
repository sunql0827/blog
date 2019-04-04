package com.sunql.blog.service.impl;

import com.sunql.blog.base.ServiceException;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;


    /**
     * 登录
     * @param userPhone
     * @param userPwd
     * @return
     */
    @Override
    public User onLogin(String userPhone, String userPwd){
        Assert.notNull(userPhone, "用户名不能为空");
        Assert.notNull(userPwd, "密码不能为空");
        User user = userMapper.loginUser(userPhone, userPwd);
        if(null == user){
            throw new ServiceException(501, "账号或密码错误");
        }
        return user;
    }

    @Override
    public User onRegister(User user) {
        return null;
    }

    @Override
    public User onVerify(String phone, String code) {
        return null;
    }

    @Override
    public String onLogout(String phone, String code) {
        return null;
    }

    @Override
    public User onUpdataInfo(User user) {
        return null;
    }

    @Override
    public String onUpdataPwd(String phone, String code, String pwd) {
        return null;
    }

    @Override
    public String onUpdataPhone(String oldphone, String newphone, String code) {
        return null;
    }
}
