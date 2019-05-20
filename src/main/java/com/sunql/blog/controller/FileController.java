package com.sunql.blog.controller;


import com.sunql.blog.base.RespCode;
import com.sunql.blog.base.RespEntity;
import com.sunql.blog.base.ServerConfig;
import com.sunql.blog.util.BasePath;
import com.sunql.blog.util.DateUtil;
import com.sunql.blog.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/blog")
public class FileController {
    @Autowired
    private ServerConfig serverConfig;
    //跳转到上传文件的页面
    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    RespEntity uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        //获取文件名（包含后缀名）
        String fileName = file.getOriginalFilename();
        String filePath = BasePath.getInstance().getUploadPath();
        String msg=serverConfig.getUrl()+ BasePath.IMAGE+fileName;
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespEntity(RespCode.WARN, e.getMessage());
            // TODO: handle exception
        } //返回json
        return new RespEntity(RespCode.SUCCESS, msg);
    }

    // 访问路径为：http://ip:port/upload
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "/fileupload";
    }

    // 访问路径为：http://ip:port/upload/batch
    @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)
    public String batchUpload() {
        return "/mutifileupload";
    }

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     * @author sunql
     * @create 2018/12/22
     */

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {

            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
              String filename= FileUtil.saveImg(file, BasePath.getInstance().getUploadPath());
              String msg=serverConfig.getUrl()+ BasePath.IMAGE+filename;
                return new RespEntity(RespCode.SUCCESS, msg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new RespEntity(RespCode.WARN, e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return new RespEntity(RespCode.WARN, e.getMessage());
            }

        } else {
            return new RespEntity(RespCode.WARN, "上传失败，因为文件是空的.");
        }
    }
    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     * @author sunql
     * @create 2018/12/22
     */

    @RequestMapping(value = "/uploadbase", method = RequestMethod.POST)
    @ResponseBody
    public RespEntity upload(@RequestParam("file") String file) {
        if (!(file==null&&file.isEmpty())) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                String filename=System.currentTimeMillis()+".jpg";
                String filiepath=BasePath.getInstance().getUploadPath()+ File.separator + filename;
                boolean isfinish= FileUtil.toGenerateImage(file,filiepath);
                if (isfinish){
                    String url=serverConfig.getUrl()+ BasePath.IMAGE+filename;
                    return new RespEntity(RespCode.SUCCESS, url);
                }else {
                    return new RespEntity(RespCode.WARN,"上传失败");
                }


            }catch (Exception e){
                e.printStackTrace();
                return new RespEntity(RespCode.WARN, e.getMessage());
            }


        } else {
            return new RespEntity(RespCode.WARN, "上传失败，因为文件是空的.");
        }
    }
    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     * @author sunql
     * @create 2018 年12月19日
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody
    RespEntity batchUpload
    (HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String name= file.getOriginalFilename();
                    String fileName = DateUtil.getTime()+i+ FileUtil.getFileSuffix(name);
                    String filepath=BasePath.getInstance().getUploadPath() + File.separator + fileName;
                    stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;

                    return new RespEntity(RespCode.WARN, e.getMessage());

                }
            } else {
                return new RespEntity(RespCode.WARN,"You failed to upload " + i + " because the file was empty.");

            }
        }
        return new RespEntity(RespCode.SUCCESS, "upload successful");
    }


}
