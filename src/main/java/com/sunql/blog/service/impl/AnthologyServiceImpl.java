package com.sunql.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunql.blog.entity.Anthology;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.AnthologyMapper;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.IAnthologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
@Service
public class AnthologyServiceImpl extends ServiceImpl<AnthologyMapper, Anthology> implements IAnthologyService {
    @Autowired
    AnthologyMapper anthologyMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Object onAddAnthology(String uid, String title) {
        QueryWrapper<User> queryUserWrapper = new QueryWrapper<>();
        queryUserWrapper.eq("uid", uid);
        User users = userMapper.selectOne(queryUserWrapper);
        if (users != null) {
            QueryWrapper<Anthology> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("title", title);
            Anthology anthology = anthologyMapper.selectOne(queryWrapper);
            if (anthology == null) {
                Long time =System.currentTimeMillis();
                anthology=new Anthology(0,time,0,title,time,uid);
                anthologyMapper.insert(anthology);
                return anthology;
            } else {
                return "文集已存在";
            }

        } else {
            return "你不是作者";
        }
    }

    @Override
    public boolean delAnthology(String uid, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        List<User> users = userMapper.selectByMap(map);
        if (users != null && users.size() > 0) {
            Anthology anthology = anthologyMapper.selectById(id);
            if (anthology != null) {
                anthologyMapper.deleteById(id);
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public boolean updataAnthology(String uid,String id, String size) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", uid);
        map.put("id", id);
        List<Anthology> anthologies = anthologyMapper.selectByMap(map);
        if (anthologies != null && anthologies.size() > 0) {
            Anthology anthology = anthologies.get(0);
           if(anthology!=null){
               long time = System.currentTimeMillis();
               anthology.setUpdataTime(time);
               anthology.setArticleSize(Integer.valueOf(size));
               anthologyMapper.updateById(anthology);
            }
            return true;


        } else {
            return false;
        }
    }
}
