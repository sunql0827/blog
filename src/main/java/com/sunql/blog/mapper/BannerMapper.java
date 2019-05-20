package com.sunql.blog.mapper;

import com.sunql.blog.entity.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunql
 * @since 2019-04-27
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {
    /**
     *
     * @param uid
     * @return
     */
    List<Banner> loadBanner(@Param("uid") String uid);

    /**
     *
     * @param type
     * @return
     */
    List<Banner> loadTypeBanner(@Param("type") String type);

}
