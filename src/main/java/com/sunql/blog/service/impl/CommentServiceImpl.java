package com.sunql.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunql.blog.entity.Article;
import com.sunql.blog.entity.Banner;
import com.sunql.blog.entity.Comment;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.ArticleMapper;
import com.sunql.blog.mapper.CommentMapper;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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
 * @since 2019-04-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Object onAddComment(String uid,Integer aid, String content) {
        QueryWrapper<User> queryUserWrapper = new QueryWrapper<>();
        queryUserWrapper.eq("uid", uid);
        User users = userMapper.selectOne(queryUserWrapper);

        Article article = articleMapper.selectById(aid);
        if (users != null&&article != null) {
            Comment comment=new Comment();
            comment.setArtId(aid);
            comment.setAuthor(article.getUserId());
            comment.setContent(content);
            comment.setUid(uid);
            Long time=System.currentTimeMillis();
            comment.setAddTime(time);
            commentMapper.insert(comment);
            int commits=article.getComment()+1;
            article.setComment(commits);
            articleMapper.updateById(article);
            QueryWrapper<Comment> queryCommentWrapper = new QueryWrapper<>();
            queryCommentWrapper.eq("art_id", aid);
            return commentMapper.selectList(queryCommentWrapper);
        } else {
            return "你不是作者";
        }
    }

    @Override
    public boolean delComment(String uid, String id) {
        Comment comment = commentMapper.selectById(id);
        if (comment == null) {
            return false;
        }
        if (comment.getAuthor()==uid || comment.getUid()==uid){
            commentMapper.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updataComment(String uid, String id, String size) {
        return false;
    }
}
