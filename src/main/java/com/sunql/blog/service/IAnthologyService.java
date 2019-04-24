package com.sunql.blog.service;

import com.sunql.blog.entity.Anthology;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunql.blog.entity.Article;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
public interface IAnthologyService extends IService<Anthology> {
    /**
     * 添加文集
     * @param title
     * @return
     */
    Object onAddAnthology(String uid, String title);

    /**
     * 删除文集
     * @param uid
     * @param id
     * @return
     */
    boolean delAnthology(String uid, String id);

    /**
     * 更新文集数量
     * @param uid
     * @param size
     * @return
     */
    boolean updataAnthology(String uid,String id, String size);

}
