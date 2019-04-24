package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.Anthology;
import com.sunql.blog.entity.Article;
import com.sunql.blog.service.impl.AnthologyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.sunql.blog.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunql
 * @since 2019-04-11
 */
@CrossOrigin
@RestController
@RequestMapping("/blog/anthology")
@Api(tags ={"1-3 文集管理"})
public class AnthologyController extends BaseController {
    @Autowired
    AnthologyServiceImpl anthologyService;


    @ApiOperation("创建文集")
    @PostMapping(value = "/addanthology")
    public RespEntity addanthology(@RequestParam("uid") String uid,@RequestParam("title") String title){
        Anthology anthology1= (Anthology) anthologyService.onAddAnthology(uid,title);
        if (anthology1!=null){
            return new RespEntity(RespCode.SUCCESS,anthology1);
        }else{
            return new RespEntity(RespCode.WARN,"创建文集失败");
        }

    }

    @ApiOperation("创建文集")
    @PostMapping(value = "/delanthology")
    public RespEntity delanthology(@RequestParam("uid") String uid,@RequestParam("id") String id){
        boolean isdel=  anthologyService.delAnthology(uid,id);
        if (isdel){
            return new RespEntity(RespCode.SUCCESS,"删除文集成功");
        }else{
            return new RespEntity(RespCode.WARN,"删除文集失败");
        }

    }

}
