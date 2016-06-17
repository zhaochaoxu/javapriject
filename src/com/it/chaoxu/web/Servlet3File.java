package com.it.chaoxu.web;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

/**
 * Created by dell on 2016/6/16.
 */
@WebServlet("/uplodfile")
@MultipartConfig//用于处理文件提交的注解
public class Servlet3File extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Servlet3File.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/uplode3.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Part part = req.getPart("doc");//获取文件元素
        logger.debug("获取文件元素{}",part);

        String filedcp = req.getParameter("filedpc");//获取文件的描述
        logger.debug("文件的描述{}",filedcp);


        String partype = part.getContentType();//获取文件的类型
        logger.debug("获取文件类型{}",partype);

        //String name = part.getName();//获取表单name的值
        String name = getfilename(part);//获取文件的原始名字
        logger.debug("获取文件名字{}",name);

        Long size = part.getSize();
        logger.debug("获取文件大小{}",size);

        //存文件
        savefile(part);


    }

    private void savefile(Part part) throws IOException {
        File file = new File("E:/uplod");

        if(!file.exists()){
            file.mkdir();
        }

        String filename = getfilename(part);
        String uuid = UUID.randomUUID().toString();
         filename = uuid + filename;

        InputStream input = part.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File(file,filename));

        IOUtils.copy(input,fos);
        /*BufferedInputStream bis = new BufferedInputStream(input);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] by = new byte[1024];
        int len = -1;
        while((len = bis.read(by))!=-1){
            bos.write(by,0,len);
        }

        bos.flush();
        bos.close();
        bis.close();*/
    }

    private String getfilename(Part part){
        String filename =part.getHeader("Content-Disposition");
        filename = filename.substring(filename.indexOf("filename=\""));
        filename = filename.substring(filename.indexOf("\"")+1,filename.length()-1);
        return filename;
    }
}
