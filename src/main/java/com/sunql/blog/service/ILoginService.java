package com.sunql.blog.service;

import com.sunql.blog.entity.Login;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunql.blog.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
public interface ILoginService extends IService<Login> {
    Login addLogin(String uid, String phone, String ip);
    /**
     * 用户退出登陆
     * @param uid
     * @return
     */
    boolean onExitLogin(String uid);
}
