package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.entity.Anthology;
import com.sunql.blog.entity.Banner;
import com.sunql.blog.service.IBannerService;
import com.sunql.blog.service.impl.AnthologyServiceImpl;
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
@Api(tags ={"1-6 轮播管理"})
@RequestMapping("/blog/banner")
public class BannerController extends BaseController {
    @Autowired
    IBannerService bannerService;


    @ApiOperation("创建轮播")
    @PostMapping(value = "/addbanner")
    public RespEntity addbanner(@RequestParam("uid") String uid,Banner banner){
       Object object= bannerService.onAddBanner(uid,banner);
       if(object!=null&&object instanceof List){
           List<Banner> banners= (List<Banner>)object;
           return new RespEntity(RespCode.SUCCESS,banners);
       }else{
           return new RespEntity(RespCode.WARN,object);
       }


    }
    @ApiOperation("创建轮播")
    @PostMapping(value = "/addbanners")
    public RespEntity addbanners(@RequestParam("uid") String uid,@RequestParam("href") String href,@RequestParam("imgs")String list){
       String[] array= list.split(",");
        Object object= bannerService.onAddBanners(uid,href,array);
        if(object!=null&&object instanceof List){
            List<Banner> banners= (List<Banner>)object;
            return new RespEntity(RespCode.SUCCESS,banners);
        }else{
            return new RespEntity(RespCode.WARN,object);
        }


    }

    @ApiOperation("删除轮播")
    @PostMapping(value = "/delbanner")
    public RespEntity delbanner(@RequestParam("uid") String uid,@RequestParam("id") String id){
        boolean isdel=  bannerService.delBanner(uid,id);
        if (isdel){
            return new RespEntity(RespCode.SUCCESS,"删除文集成功");
        }else{
            return new RespEntity(RespCode.WARN,"删除文集失败");
        }

    }
}
