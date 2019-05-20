package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.Banner;
import com.sunql.blog.entity.Comment;
import com.sunql.blog.service.IBannerService;
import com.sunql.blog.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-04-27
 */
@CrossOrigin
@RestController
@Api(tags ={"1-7 评论管理"})
@RequestMapping("/blog/comment")
public class CommentController extends BaseController {
    @Autowired
    ICommentService commentService;


    @ApiOperation("添加评论")
    @PostMapping(value = "/addcomment")
    public RespEntity addcomment(@RequestParam("uid") String uid,@RequestParam("aid") Integer aid,@RequestParam("content") String content){
        Object object= commentService.onAddComment(uid,aid,content);
        if(object!=null&&object instanceof List){
            List<Comment> banners= (List<Comment>)object;
            return new RespEntity(RespCode.SUCCESS,banners);
        }else{
            return new RespEntity(RespCode.WARN,object);
        }


    }

    @ApiOperation("删除评论")
    @PostMapping(value = "/delcomment")
    public RespEntity delbanner(@RequestParam("uid") String uid,@RequestParam("id") String id){
        boolean isdel=  commentService.delComment(uid,id);
        if (isdel){
            return new RespEntity(RespCode.SUCCESS,"删除文集成功");
        }else{
            return new RespEntity(RespCode.WARN,"删除文集失败");
        }

    }
}
