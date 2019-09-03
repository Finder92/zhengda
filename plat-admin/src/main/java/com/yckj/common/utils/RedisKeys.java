package com.yckj.common.utils;

/**
 * Redis所有Keys
 *
 * @author Finder zhangzhili92@163.com
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
