package com.it.chaoxu.Util;

import com.it.chaoxu.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by dell on 2016/6/9.
 */

public class ConnectionManager  {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {

        dataSource.setDriverClassName(config.get("jdbc.driver"));
        dataSource.setUrl(config.get("jdbc.url"));
        dataSource.setUsername(config.get("jdbc.username"));
        dataSource.setPassword(config.get("jdbc.password"));

        dataSource.setInitialSize(new Integer(config.get("jdbc.initsize","5")));
        dataSource.setMaxTotal(new Integer(config.get("jdbc.maxsize","20")));
        dataSource.setMaxWaitMillis(new Integer(config.get("jdbc.maxwait","5000")));
        dataSource.setMaxIdle(new Integer(config.get("jdbc.maxidle","10")));
        dataSource.setMinIdle(new Integer(config.get("jdbc.minidle","5")));
    }

    public static DataSource getdataSource(){
        return dataSource;
    }
    public static Connection getconn() throws DataAccessException {
        try {
            try {
               Class.forName(dataSource.getDriverClassName());
                Connection connection = dataSource.getConnection();//从连接池中连接数据库
                return connection;
            } catch (ClassNotFoundException e) {
            throw new DataAccessException("数据库驱动出错",e);
            }
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接失败",e);
        }

    }

    public void connClose(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
           throw new DataAccessException("数据库关闭异常",e);
        }
    }
}
