package com.sunql.blog.service.impl;

import com.sunql.blog.base.ServiceException;
import com.sunql.blog.entity.Login;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.LoginMapper;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.ILoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunql.blog.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {
    @Autowired
    LoginMapper loginMapper;


    /**
     * 登录
     * @param uid
     * @param phone
     * @return
     */
    @Override
    public Login addLogin(String uid, String phone, String ip){

        Login login=new Login();
        String timeStr=String.valueOf(System.currentTimeMillis());
        login.setIpaddress(ip);
        login.setLoginstate(1);
        login.setLogintime(timeStr);
        login.setUid(uid);
        String token = MD5.md5(timeStr,phone);
        login.setToken(token);
        loginMapper.insert(login);

        return login;
    }
    /**
     * 退出用户
     * @param uid
     * @return
     */
    @Override
    public boolean onExitLogin(String uid) {
        Login login= loginMapper.selectUid(uid);
        String timeStr=String.valueOf(System.currentTimeMillis());
        login.setOutlogintime(timeStr);
        login.setLoginstate(1);
        loginMapper.updateById(login);
        return true;
    }
}
