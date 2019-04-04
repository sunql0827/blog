package com.sunql.blog.service.impl;

import com.sunql.blog.entity.Article;
import com.sunql.blog.mapper.ArticleMapper;
import com.sunql.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
