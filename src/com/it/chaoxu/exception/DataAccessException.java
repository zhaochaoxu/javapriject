package com.it.chaoxu.exception;

/**
 * Created by dell on 2016/6/11.
 */
public class DataAccessException extends RuntimeException {
    public DataAccessException(){};

    public DataAccessException(String mes){
        super(mes);
    };

    public DataAccessException(String mes, Exception ex){
        super(mes,ex);
    }
}
