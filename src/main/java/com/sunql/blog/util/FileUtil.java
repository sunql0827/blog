package com.sunql.blog.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class FileUtil {

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
        return fileName;
    }

    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
        String name= multipartFile.getOriginalFilename();
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();

        String fileName =DateUtil.getTime()+ getFileSuffix(name);
        String filepath=path + File.separator + fileName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
    //图片转化成base64字符串
    public static String GetImageStr(String path)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = path;//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    //base64字符串转化成图片
    public static boolean toGenerateImage(String imgStr,String path)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null){
            //图像数据为空
            return false;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            String baseValue = imgStr.replaceAll(" ", "+");//前台在用Ajax传base64值的时候会把base64中的+换成空格，所以需要替换回来。
            byte[] b = decoder.decodeBuffer(baseValue.replace("data:image/jpeg;base64,", ""));//去除base64中无用的部分
            imgStr = imgStr.replace("base64,", "");

            //Base64解码
            //byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = path;//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    /**
     * 获取文件名
     * @param filename
     * @return
     */
    public static String getFileName(String filename){
        String caselsh = filename.substring(0,filename.lastIndexOf("."));
        return caselsh;
    }

    /**
     * 获取文件名后缀
     * @param filename
     * @return
     */
    public static String getFileSuffix(String filename){
        String suffix  ="."+ filename.substring(filename.lastIndexOf(".")+1);
        return suffix;
    }
}
