package com.it.chaoxu.Test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by dell on 2016/6/14.
 */
public class md5test {
    @Test
    public void testmd5(){
        String name = "zcx";
        String pwd="333";
        String salt = "#^(*&^^%*&&*&^%^$%#$&^&*%^";
        pwd= DigestUtils.md5Hex(pwd+salt);
        System.out.println(pwd);
    }
}
