package com.it.chaoxu.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by dell on 2016/6/15.
 */
public class config {
    static  Logger logger = LoggerFactory.getLogger(config.class);
    private  static Properties prop = new Properties();
    static {
       try {
           prop.load(config.class.getClassLoader().getResourceAsStream("config.properties"));
       } catch (IOException e) {
           logger.error("读取config.properties文件失败");
           e.printStackTrace();
       }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }

    public static String get(String key,String defautvalue){
        return prop.getProperty(key,defautvalue);

    }
}
