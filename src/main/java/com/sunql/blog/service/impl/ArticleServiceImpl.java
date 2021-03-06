package com.sunql.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunql.blog.entity.*;
import com.sunql.blog.mapper.*;
import com.sunql.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunql.blog.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AnthologyMapper anthologyMapper;
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    CommentMapper commentMapper;
    /**
     * 创建文集
     *
     * @param uid
     * @param article
     * @return
     */
    @Override
    public Object onAddArticle(String uid, Article article) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        List<User> users = userMapper.selectByMap(map);
        if (users != null && users.size() > 0) {
            Map<String, Object> articlemap = new HashMap<>();
            articlemap.put("art_title", article.getArtTitle());
            List<Article> articles = articleMapper.selectByMap(articlemap);
            if (articles == null) {
                articleMapper.insert(article);
                return article;
            } else {
                return "文章已存在";
            }

        } else {
            return "你不是作者";
        }

    }

    /**
     * 更新文章
     *
     * @param uid
     * @param id
     * @return
     */
    @Override
    public Object onUpdataArticle(String uid, Integer id, String title, String context) {
        Article article = articleMapper.selectArticleOne(uid, id);
        if (article != null) {
            if (StringUtil.isExist(title)) {
                article.setArtTitle(title);
            }
            if (StringUtil.isExist(context)) {
                article.setArtDesc(context);
                article.setWords(context.length());
                article.setIntro(StringUtil.getIntro(context, 20));
            }

            long time = System.currentTimeMillis();
            article.setUpdataTime(time);
            articleMapper.updateById(article);
            return article;


        } else {
            return "更新文章不存在";
        }

    }

    @Override
    public boolean onDelArticle(String uid, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        List<User> users = userMapper.selectByMap(map);
        if (users != null && users.size() > 0) {
            Article article1 = articleMapper.selectById(id);
            if (article1 != null) {
                articleMapper.deleteById(id);
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    public boolean onUpdataArtType(String uid, String artType) {
        return false;
    }


    @Override
    public Article onUpdataIslike(Integer id,Integer islike) {
        Article article = articleMapper.selectById(id);
        if (article != null) {
            if (islike==1){
              int likes= article.getIslike()+1;
                article.setIslike(likes);
            }else if (islike==0&&article.getIslike()>0){
                int likes= article.getIslike()-1;
                article.setIslike(likes);
            }

            articleMapper.updateById(article);
            return article;
        } else {
            return null;
        }

    }

    @Override
    public boolean onUpdataIsread(Integer id,Integer isread) {

        return false;
    }

    @Override
    public boolean isRelease(String uid, Integer id, Integer type) {
        Article article = articleMapper.selectArticleOne(uid, id);
        if (article != null) {
            article.setIsread(type);
            articleMapper.updateById(article);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean addComment(Integer id,boolean comment) {
        return false;
    }

    @Override
    public List<Article> getArticle() {
        List<Article> articles = articleMapper.selectAll();

        return articles;
    }

    /**
     * 获取首页
     * @param uid
     * @return
     */
    @Override
    public Object getHomeArticle(String uid) {
        Map<String, Object> data = new ConcurrentHashMap();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", 1);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        data.put("articles", articles);
        List<Banner> banners = bannerMapper.loadBanner(uid);
        if (banners.size()==0){
            banners = bannerMapper.loadTypeBanner(String.valueOf(10));
        }
        data.put("banners", banners);
        return data;
    }

    @Override
    public Map<String, Object> getArticleorAnthology(String uid) {
        Map<String, Object> data = new ConcurrentHashMap();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", uid);
        List<Article> articles = articleMapper.selectByMap(map);
        List<Anthology> anthologies = anthologyMapper.selectByMap(map);
        data.put("articles", articles);
        data.put("anthologies", anthologies);
        return data;
    }

    @Override
    public Map<String, Object> getArticleInfo(Integer id) {
        Map<String, Object> data = new ConcurrentHashMap();

        Article articles = articleMapper.selectById(id);
        if (articles == null) {
            return null;
        }
        int reads=articles.getIsread()+1;
        articles.setIsread(reads);
        articleMapper.updateById(articles);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", articles.getUserId());
        User users = userMapper.selectOne(queryWrapper);
        if (users == null) {
            return null;
        }
        QueryWrapper<Comment> queryCommentWrapper = new QueryWrapper<>();
        queryCommentWrapper.eq("art_id", articles.getId());
        List<Comment> comments= commentMapper.selectList(queryCommentWrapper);
        data.put("article", articles);
        data.put("user", users);
        data.put("comments", comments);
        return data;


    }
}
