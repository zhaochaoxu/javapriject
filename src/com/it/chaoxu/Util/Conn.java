package com.it.chaoxu.Util;

import com.it.chaoxu.exception.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dell on 2016/6/16.
 */
public class Conn {




    public static Connection getcon(){
         String driver="com.mysql.jdbc.Driver";
         String url = "jdbc:mysql:///learn";
         String user = "root";
         String pwd = "0314";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("Driver",e);
        }
        try {
            Connection conn = DriverManager.getConnection(url,user,pwd);
            return conn;
        } catch (SQLException e) {
            throw new DataAccessException("database",e);
        }
    }
}
