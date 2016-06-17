package com.it.chaoxu.dao;

import com.it.chaoxu.Util.Dbhelp;
import com.it.chaoxu.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by dell on 2016/6/11.
 */
public class Userdao {
    public void Adduser(User u){
        String sql="insert into username(name,password,address) values(?,?,?)";
        Dbhelp.update(sql,u.getName(),u.getPassword(),u.getAddress());
    }

    public void deluser(int id){
        String sql="delete from username where id=?";
        Dbhelp.update(sql,id);
    }
    public void updateuser(User u,int id){
        String sql="update username set name=?,password=?,address=? where id=?";
        Dbhelp.update(sql,u.getName(),u.getPassword(),u.getAddress(),id);
    }

    public User queryone(int id){
        String sql="select * from username where id=?";
        return Dbhelp.Query(sql,new BeanHandler<User>(User.class),id);
    }
    public User queryonebyname(String name){
        String sql="select * from username where name=?";
        return Dbhelp.Query(sql,new BeanHandler<User>(User.class),name);
    }

    public List<User>queryAll(){
        String sql = "select* from username";
        return Dbhelp.Query(sql,new BeanListHandler<User>(User.class));
    }
}
