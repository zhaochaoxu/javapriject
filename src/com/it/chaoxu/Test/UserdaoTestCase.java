package com.it.chaoxu.Test;

import com.it.chaoxu.dao.Userdao;
import com.it.chaoxu.entity.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by dell on 2016/6/11.
 */
public class UserdaoTestCase {
    private Userdao dao = new Userdao();
    @Test
    public void testadd(){
        User u= new User("牛丽丽","9879","中国");
        dao.Adduser(u);
    }
    @Test
    public void testdel(){
    dao.deluser(3);
    }

    @Test
    public void testup(){
        User u = new User();
        u.setName("李四");
        u.setPassword("369");
        u.setAddress("哈或");
        dao.updateuser(u,6);
    }
    @Test
    public void testone(){
        User u =dao.queryone(6);
        System.out.println(u);
    }
    @Test
    public void testonebyname(){
        User u =dao.queryonebyname("zcx");
        System.out.println(u);
    }

    @Test
    public void testall(){
        List<User> u =dao.queryAll();
        for (User us: u) {
            System.out.println(us);
        }
    }
}
