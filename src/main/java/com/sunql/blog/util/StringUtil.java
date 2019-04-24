package com.sunql.blog.util;

public class StringUtil {
    public static boolean  isExist(String msg){
        if (msg==null){
            return false;
        }
        if ("".equals(msg.trim())){
            return false;
        }
        if (msg.trim().length()>0){
            return true;
        }else {
            return false;
        }
    }
    public static boolean  isExist(String msg,int lenght){
        if (msg==null){
            return false;
        }
        if ("".equals(msg.trim())){
            return false;
        }
        if (msg.trim().length()>=lenght){
            return true;
        }else {
            return false;
        }
    }
    public static boolean  isExistLong(Long value){
        if (value>0){
            return true;
        }else {
            return false;
        }

    }
    public static  String getIntro(String desc,int length){
        String str="";
        if (desc.contains("<p>")){
            String[] array=desc.split("<p>");
            if (array!=null&&array.length>0){
                str= array[1].substring(0,length);
            }
        }else{
            if(desc.length()>length){
                str=desc.substring(0,length);
            }else {
                str=desc;
            }

        }

        return str;
    }
}
