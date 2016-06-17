package com.it.chaoxu.dao;

import com.it.chaoxu.Util.ConnectionManager;
import com.it.chaoxu.Util.Dbhelp;
import com.it.chaoxu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Dbutiltest {
    @Test
    public void testcoon(){
        ConnectionManager.getconn();
    }
    @Test
    public void add() {
        String sql = "insert into username(name,password,address) values(?,?,?)";
        Dbhelp.update(sql,"牛丽娟","666","聊城");
    }

    @Test
    public void testdel() {
        String sql = "delete from username where id = ?";
        Dbhelp.update(sql,4);
    }

    @Test
    public void testupde() {
        String sql = "update username set name=? where id = ? ";
        Dbhelp.update(sql,"思密达",6);
    }

    @Test
    public void testQueryonebyid() {
        String sql = "select* from username where id=?";
        User u=Dbhelp.Query(sql,new BeanHandler<>(User.class),6);
        System.out.println(u);
    }

    @Test
    public void testAll() {
        String sql = "select*from username";
        //DbHelp.Query(sql.new BeanHandler)
    }

    @Test
    public void testquertmap() {
        String sql = "select * from username where id=?";
        Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner();

        try {
            Map<String, Object> result = qr.query(conn, sql, new MapHandler(), 2);
            System.out.println(result);
            for (Map.Entry<String, Object> user : result.entrySet()) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connClose(conn);
        }
    }

    @Test
    public void testquertmaplist() {
        String sql = "select * from username";
        Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner();

        try {
            List<Map<String, Object>> result = qr.query(conn, sql, new MapListHandler());
            for (int i = 0; i < result.size(); i++) {
                Map<String, Object> res = result.get(i);
                for (Map.Entry<String, Object> user : res.entrySet()) {
                    System.out.println(user);
                }
                System.out.println("=====================");
            }
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connClose(conn);
        }
    }
    @Test
    public void testcount() {
        String sql = "select count(*) from username";
        Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner();
        try {
            Long count = qr.query(conn, sql, new ScalarHandler<Long>());
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connClose(conn);
        }
    }

    @Test
    public void testAllname() {
        String sql = "select name from username";
        Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner();
        try {
            List<String> namelist= qr.query(conn, sql,new ColumnListHandler<String>());
            System.out.println(namelist);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connClose(conn);
        }
    }

    public void connClose(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }
}