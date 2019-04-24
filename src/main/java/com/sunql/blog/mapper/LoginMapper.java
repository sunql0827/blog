package com.sunql.blog.mapper;

import com.sunql.blog.entity.Login;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunql.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
@Repository
public interface LoginMapper extends BaseMapper<Login> {
    /**
     * 查找指定记录
     * @param uid
     * @return
     */
    Login selectUid(@Param("uid") String uid);
}
