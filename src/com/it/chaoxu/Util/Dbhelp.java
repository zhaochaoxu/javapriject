package com.it.chaoxu.Util;


import com.it.chaoxu.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;

/**
 * Created by dell on 2016/6/9.
 */
public class Dbhelp {

    public static void update(String sql, Object... param) throws DataAccessException {
        //Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner(ConnectionManager.getdataSource());
        try {
            qr.update(sql, param);
        } catch (SQLException e) {
            throw new DataAccessException("增删改方法出错",e);
        }

    }

    public static <T> T Query(String sql, ResultSetHandler<T> handler, Object... param)throws DataAccessException {
        // Connection conn = ConnectionManager.getconn();
        QueryRunner qr = new QueryRunner(ConnectionManager.getdataSource());
        try {
            return qr.query(sql, handler, param);
        } catch (SQLException e) {
            throw new DataAccessException("查询方法出错",e);
        }
    }

}
