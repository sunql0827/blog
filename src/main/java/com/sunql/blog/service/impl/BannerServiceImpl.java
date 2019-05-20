package com.sunql.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunql.blog.entity.Anthology;
import com.sunql.blog.entity.Banner;
import com.sunql.blog.entity.Comment;
import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.BannerMapper;
import com.sunql.blog.mapper.UserMapper;
import com.sunql.blog.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunql.blog.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BannerMapper bannerMapper;
    @Override
    public Object onAddBanner(String uid, Banner banner) {
        QueryWrapper<User> queryUserWrapper = new QueryWrapper<>();
        queryUserWrapper.eq("uid", uid);
        User users = userMapper.selectOne(queryUserWrapper);
        if (users != null) {
            QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid", uid);
            List<Banner> banners = bannerMapper.selectList(queryWrapper);
            if (banners != null&&banners.size()<5) {
                Long time =System.currentTimeMillis();
                banner.setAddTime(time);
                banner.setUpdataTime(time);
                bannerMapper.insert(banner);

                QueryWrapper<Banner> queryBannerWrapper = new QueryWrapper<>();
                queryBannerWrapper.eq("uid", uid);
                return bannerMapper.selectList(queryBannerWrapper);
            } else {
                return "轮播大于5张，请先删除";
            }

        } else {
            return "你不是作者";
        }

    }

    @Override
    public Object onAddBanners(String uid,String href, Object object) {
        QueryWrapper<User> queryUserWrapper = new QueryWrapper<>();
        queryUserWrapper.eq("uid", uid);
        User users = userMapper.selectOne(queryUserWrapper);
        if (users != null) {
            QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid", uid);
            List<Banner> banners = bannerMapper.selectList(queryWrapper);
            if (banners != null&&banners.size()<5) {
                if (object instanceof  String[]){
                    String[] mbanners= (  String[]) object;
                    Long time =System.currentTimeMillis();
                    for(int i = 0,len= mbanners.length; i < len ; i++) {
                       Banner banner=new Banner();
                       banner.setImgurl(mbanners[i]);
                       banner.setType(1);
                       banner.setHref(href);
                       banner.setTitle(String.valueOf(time));
                       banner.setAddTime(time);
                       banner.setUpdataTime(time);
                       banner.setUid(uid);
                       bannerMapper.insert(banner);

                    }

                }
                QueryWrapper<Banner> queryBannerWrapper = new QueryWrapper<>();
                queryBannerWrapper.eq("uid", uid);
                return bannerMapper.selectList(queryBannerWrapper);
            } else {
                return "轮播大于5张，请先删除";
            }

        } else {
            return "你不是作者";
        }
    }

    @Override
    public boolean delBanner(String uid, String id) {
        Banner banner = bannerMapper.selectById(id);
        if (banner == null) {
            return false;
        }
        if (banner.getUid()==uid ){
            bannerMapper.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Object updataBanner(String uid, String id, String title, String imgurl, String href, Integer type) {
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        queryWrapper.eq("id", id);
        Banner banners = bannerMapper.selectOne(queryWrapper);
        if (banners != null) {
            if(StringUtil.isExist(title)){
                banners.setTitle(title);
            }
            if(StringUtil.isExist(imgurl)){
                banners.setImgurl(imgurl);
            }
            if(StringUtil.isExist(href)){
                banners.setHref(href);
            }
            if(type.equals(banners.getType())){
                banners.setType(type);
            }
            Long time =System.currentTimeMillis();
            banners.setUpdataTime(time);
            bannerMapper.insert(banners);
            return banners;
        } else {
            return "更新失败";
        }

    }


}
