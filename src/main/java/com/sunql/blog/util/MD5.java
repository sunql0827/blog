package com.sunql.blog.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key){
        //确定计算方法
        String str = text + key;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String encodeStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
            System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
            return encodeStr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * MD5验证方法
     *
     * @param newpasswd 新密码
     * @param oldpasswd 老密码
     * @return true/false
     * @throws Exception
     */
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (newpasswd.equals(oldpasswd)) {
            return true;
        } else {
            return false;
        }

    }
}
