package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.Article;
import com.sunql.blog.service.impl.ArticleServiceImpl;
import com.sunql.blog.service.impl.UserServiceImpl;
import com.sunql.blog.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-04-04
 */
@CrossOrigin
@RestController
@RequestMapping("/blog/article")
@Api(tags ={"1-2 博客管理"})
public class ArticleController extends BaseController {
    @Autowired
    private ArticleServiceImpl articleService;


    @ApiOperation("创建博客")
    @PostMapping(value = "/addarticle")
    public RespEntity addarticle(@RequestParam("uid") String uid, Article article){
        Article article1= (Article) articleService.onAddArticle(uid,article);
        if (article1!=null){
            return new RespEntity(RespCode.SUCCESS,article1);
        }else{
            return new RespEntity(RespCode.WARN,"创建文章失败");
        }

    }
    @ApiOperation("更新博客")
    @PostMapping(value = "/updataarticle")
    public RespEntity updataarticle(@RequestParam("uid") String uid,@RequestParam("id") Integer id,@RequestParam("title") String title,@RequestParam("context") String context){
        Article article= (Article) articleService.onUpdataArticle(uid,id,title,context);
        if (article!=null){
            return new RespEntity(RespCode.SUCCESS,article);
        }else{
            return new RespEntity(RespCode.WARN,"更新文章失败");
        }

    }
    @ApiOperation("删除博客")
    @PostMapping(value = "/delarticle")
    public RespEntity delarticle(@RequestParam("uid") String uid,@RequestParam("aid") String aid){
        boolean isdel=articleService.onDelArticle(uid,aid);
        if (isdel){
            return new RespEntity(RespCode.SUCCESS,"删除成功");
        }else{
            return new RespEntity(RespCode.WARN,"删除失败");
        }

    }
    @ApiOperation("首页博客")
    @PostMapping(value = "/bloghome")
    public RespEntity bloghome(@RequestParam("uid") String uid){
        Object data =articleService.getHomeArticle(uid);
        if (data!=null){
            return new RespEntity(RespCode.SUCCESS,data);
        }else{
            return new RespEntity(RespCode.WARN,"暂无数据");
        }

    }
    /**
     * 查询文章列表+文集
     *
     * @return
     */
    @ApiOperation("文集&博客列表")
    @PostMapping (value = "/articlepage")
    public RespEntity articlepage(@RequestParam("uid") String id) {
        if (StringUtil.isExist(id)) {
          Map<String,Object> data= articleService.getArticleorAnthology(id);
            return new RespEntity(RespCode.SUCCESS, data);
        } else {
            return new RespEntity(RespCode.WARN, "文章不存在，请重新输入");
        }
    }
    /**
     * 发表文章
     *
     * @param id
     * @param isRelease 是否发布
     * @return
     */
    @PostMapping(value = "/change_release")
    public RespEntity changeRelease(@RequestParam("uid") String uid,@RequestParam("id") Integer id, @RequestParam("is_release") Integer isRelease) {
       boolean isrelease = articleService.isRelease(uid,id,isRelease);
        if (isrelease) {
            return new RespEntity(RespCode.SUCCESS, "发表成功");
        } else {
            return new RespEntity(RespCode.WARN, "文章不存在，请重新输入");
        }
    }

    /**
     * 查询一篇文章
     *
     * @return
     */
    @PostMapping (value = "/article")
    public RespEntity singlearticle(@RequestParam("id") Integer id) {

        Map<String, Object> map= articleService.getArticleInfo(id);
        if (map != null && map.size() > 0) {
            return new RespEntity(RespCode.SUCCESS, map);
        } else {
            return new RespEntity(RespCode.WARN, "文章不存在，请重新输入");
        }

    }

    /**
     * 查询一篇文章
     *
     * @return
     */
    @PostMapping (value = "/likearticle")
    public RespEntity onlikearticle(@RequestParam("id") Integer id,@RequestParam("islike") Integer like ){
       Article article= articleService.onUpdataIslike(id,like);
        if (article!=null) {
            return new RespEntity(RespCode.SUCCESS, article);
        } else {
            return new RespEntity(RespCode.WARN, "文章不存在，请重新输入");
        }

    }

}
