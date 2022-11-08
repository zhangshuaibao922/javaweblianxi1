package com.atguigu.fruit.pojo.com.atguigu.myssm.util;

/**
 * @author Ricardo
 * @create 2022-11-04 12:11
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        return str==null||"".equals(str);
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
