package com.it.chaoxu.Test;

import com.it.chaoxu.Util.Conn;
import com.it.chaoxu.Util.ConnectionManager;
import com.it.chaoxu.entity.User;
import com.it.chaoxu.service.UserService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dell on 2016/6/14.
 */
public class UserServicetestCase {
    private UserService us = new UserService();
    @Test
    public void testserservice(){
        User user = us.login("zcx","333");
        Assert.assertNotNull(user);
    }
    @Test
    public void testconn(){
        ConnectionManager.getconn();
    }
    @Test
    public void testcon(){
        Conn.getcon();
    }
}
