package com.sunql.blog.service;

import com.sunql.blog.entity.Banner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-04-27
 */
public interface IBannerService extends IService<Banner> {
    /**
     * 添加文集
     * @param banner
     * @return
     */
    Object onAddBanner(String uid, Banner banner);
    /**
     * 添加文集
     * @param object
     * @return
     */
    Object onAddBanners(String uid,String href, Object object);

    /**
     * 删除文集
     * @param uid
     * @param id
     * @return
     */
    boolean delBanner(String uid, String id);

    /**
     * 更新文集数量
     * @param uid
     * @param title
     * @return
     */
    Object updataBanner(String uid,String id,String title,String imgurl,String href,Integer type);

}
