package com.sunql.blog.service;

import com.sunql.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-04-27
 */
public interface ICommentService extends IService<Comment> {
    /**
     * 添加文集
     * @param aid
     * @param content 评论内容
     * @return
     */
    Object onAddComment(String uid,Integer aid, String content);

    /**
     * 删除文集
     * @param uid
     * @param id
     * @return
     */
    boolean delComment(String uid, String id);

    /**
     * 更新文集数量
     * @param uid
     * @param size
     * @return
     */
    boolean updataComment(String uid,String id, String size);

}
