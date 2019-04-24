package com.sunql.blog.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class BasePath {
    public static String IMAGE="images/";
    public static String BASE_URL="http://www.sunql.top/";
    static BasePath basePath=null;
    public static BasePath getInstance() {
        if (basePath==null){
            basePath=new BasePath();
        }
        return basePath;
    }
    /**
     * 获取根目录
     *
     * @return
     */
    public String getAbsolutePath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            return path.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取上传目录
     * @return
     */
    public String getUploadPath() {
        String path=getAbsolutePath();
        File upload = new File(path, "static/images/upload/");
        if (!upload.exists()){
            upload.mkdirs();
        }
       return upload.getAbsolutePath();

    }
    /**
     * 获取上传目录
     * @return
     */
    public String getImagePath() {
        String path=getTomcatPath();
        File upload = new File(path, "/webapps/"+IMAGE);
        if (!upload.exists()){
            upload.mkdirs();
        }
        return upload.getAbsolutePath();

    }
    /**
     * 获取tomcat路径
     * @return
     */
    public String getTomcatPath(){
        String path=System.getProperty("catalina.home");
        return path;
    }
    public String getImageUrl(){
        return BASE_URL+IMAGE;
    }

}
