package com.sunql.blog.service;

import com.sunql.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
public interface IUserService extends IService<User> {
    /**
     * 用户登陆
     * @param userPhone
     * @param userPwd
     * @return
     */
    User onLogin(String userPhone, String userPwd);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User onRegister(User user);

    /**
     * 验证用户
     * @param phone
     * @param code
     * @return
     */
    User onVerify(String phone,String code);

    /**
     * 注销用户
     * @param phone
     * @param code
     * @return
     */
    String onLogout(String phone,String code);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    User onUpdataInfo(User user);

    /**
     * 更改密码
     * @param phone
     * @param code
     * @param pwd
     * @return
     */
    String  onUpdataPwd(String phone,String code,String pwd);

    /**
     * 更改用户手机号
     * @param oldphone
     * @param newphone
     * @param code
     * @return
     */
    String  onUpdataPhone(String oldphone,String newphone,String code);
}
