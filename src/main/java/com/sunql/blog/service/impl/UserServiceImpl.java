package com.sunql.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunql.blog.base.ServiceException;
import com.sunql.blog.entity.Article;
import com.sunql.blog.entity.Comment;
import com.sunql.blog.entity.Login;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.ArticleMapper;
import com.sunql.blog.mapper.CommentMapper;
import com.sunql.blog.mapper.LoginMapper;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunql.blog.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CommentMapper commentMapper;
    /**
     * 登录
     * @param userPhone
     * @param userPwd
     * @return
     */
    @Override
    public User onLogin(String userPhone, String userPwd,String ip){
        Assert.notNull(userPhone, "用户名不能为空");
        Assert.notNull(userPwd, "密码不能为空");
        User user = userMapper.loginUser(userPhone, userPwd);

        if(null == user){
            throw new ServiceException(501, "账号或密码错误");
        }else{
            Login login=new Login();
            String timeStr=String.valueOf(System.currentTimeMillis());

            login.setIpaddress(ip);
            login.setLoginstate(1);
            login.setLogintime(timeStr);
            login.setUid(user.getUid());
            String token = MD5.md5(timeStr,userPhone);
            login.setToken(token);
            loginMapper.insert(login);
        }
        return user;
    }



    /**
     *注册
     * @param user
     * @return
     */
    @Override
    public Object onRegister(User user) {
        Assert.notNull(user.getUserPhone(), "用户名不能为空");
        Assert.notNull(user.getUserPwd(), "密码不能为空");

        User user1= userMapper.selectPhone(user.getUserPhone());
        if (user1==null){
           Long time=System.currentTimeMillis();
            String uid = MD5.md5(String.valueOf(time), String.valueOf(user.getUserPhone()));
            if (uid.contains("/")){
                String random=String.valueOf(Math.random()*10);
                uid=uid.replace("/",random);
            }
            user.setUid(uid);
            user.setUserAddress("中国");
            user.setUserPhoto("http://www.sunql.top/images/basephoto.jpeg");
            user.setUserSex(1);
            user.setAddTime(time);
            user.setUpdataTime(time);
            user.setUserAge(18);


            userMapper.insert(user);
            return user;
        }else{
            return  "用户已经存在";
        }

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

    @Override
    public Object userinfo(String uid) {
        Map<String, Object> data = new ConcurrentHashMap();
        QueryWrapper<User> queryUserWrapper = new QueryWrapper<>();
        queryUserWrapper.eq("uid", uid);
        User users = userMapper.selectOne(queryUserWrapper);
        if (users!=null){
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", uid);
            QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
            articleQueryWrapper.eq("user_id", uid);
            List<Article> articles = articleMapper.selectList(articleQueryWrapper);
            QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
            commentQueryWrapper.eq("uid", uid);
            List<Comment> comments= commentMapper.selectList(commentQueryWrapper);
            data.put("user",users);
            data.put("articles",articles);
            data.put("comments",comments);
            return data;
        }else {
            return "用户不存在";
        }

    }
}
