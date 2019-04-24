package com.sunql.blog.mapper;

import com.sunql.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunql
 * @since 2019-03-31
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 登陆用户
     * @param user_phone
     * @param user_pwd
     * @return
     */
    User loginUser(@Param("user_phone") String user_phone, @Param("user_pwd") String user_pwd);
    /**
     * 查询手机号
     * @param user_phone
     * @return
     */
    User selectPhone(@Param("user_phone") Long user_phone);



}
