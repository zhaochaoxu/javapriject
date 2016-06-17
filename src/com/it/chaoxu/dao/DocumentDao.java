package com.it.chaoxu.dao;

import com.it.chaoxu.Util.Dbhelp;
import com.it.chaoxu.entity.Document;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by dell on 2016/6/16.
 */
public class DocumentDao {

    public void documentsave(Document document){
        String sql = "INSERT INTO `t-file`( filename, savename, md5, size, displaysize) VALUES (?,?,?,?,?)";
        Dbhelp.update(sql,document.getFilename(),document.getSavename(),document.getMd5(),document.getSize(),document.getDisplaysize());
    }

    public Document findbymd5(String md5){
        String sql = "select * from t-file where md5=?";
        return Dbhelp.Query(sql,new BeanHandler<>(Document.class),md5);

    }

    public Document findbyfilename(String filename){
        String sql = "select * from t-file where filename=?";
        return Dbhelp.Query(sql,new BeanHandler<>(Document.class),filename);

    }
}
