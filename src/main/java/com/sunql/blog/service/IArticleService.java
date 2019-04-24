package com.sunql.blog.service;

import com.sunql.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunql.blog.entity.User;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
public interface IArticleService extends IService<Article> {
    /**
     * 添加文章
     * @param article
     * @return
     */
    Object onAddArticle(String uid,Article article);
    /**
     * 更新文章
     * @param uid
     * @param id
     * @param title
     * @param context
     * @return
     */
    Object onUpdataArticle(String uid,Integer id,String title,String context);
    /**
     * 删除文章
     * @param id
     * @return
     */
    boolean onDelArticle(String uid,String id);
    /**
     * 更修文集
     * @param artType
     * @return
     */
    boolean onUpdataArtType(String uid,String artType);
    /**
     * 是否喜欢
     * @param islike
     * @return
     */
    boolean onUpdataIslike(boolean islike);
    /**
     * 记录阅读
     * @param isread
     * @return
     */
    boolean onUpdataIsread(boolean isread);
    /**
     * 是否发布
     * @param user_id
     * @param id
     * @param type
     * @return
     */
    boolean isRelease(String user_id,Integer id,Integer type);
    /**
     * 添加评论
     * @param comment
     * @return
     */
    boolean addComment(boolean comment);

    /**
     * 获取全部
     * @return
     */
    List<Article> getArticle();

    /**
     * 根据作者id查找
     * @return
     */
    Map<String,Object> getArticleorAnthology(String uid);

    Map<String,Object> getArticleInfo(Integer id);
}
