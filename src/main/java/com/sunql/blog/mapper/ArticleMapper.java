package com.sunql.blog.mapper;

import com.sunql.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
   List<Article> selectAll();

   List<Article> selectArticleList(@Param("user_id") String user_id);

   Article selectArticleOne(@Param("user_id") String user_id,@Param("id") Integer id);
}
