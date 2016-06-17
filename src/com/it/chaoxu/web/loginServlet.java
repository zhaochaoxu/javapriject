package com.it.chaoxu.web;

import com.it.chaoxu.dao.Userdao;
import com.it.chaoxu.entity.User;
import com.it.chaoxu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dell on 2016/6/14.
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(loginServlet.class);
    Userdao dao = new Userdao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //判断验证码是否输入正确
        String captcha = req.getParameter("captcha");
        HttpSession session =  req.getSession();
        String sessioncaptcha = (String)session.getAttribute("captcha");
        if(captcha!=null&&captcha.equalsIgnoreCase(sessioncaptcha)){

            String name = req.getParameter("username");
            String password = req.getParameter("password");
            UserService us = new UserService();
            User user = us.login(name,password);
            //User user = dao.queryonebyname(name);
            if(user==null){
                resp.sendRedirect("/login?code=1002");
            }else{

                logger.debug("{}登录成功!!!",name);
            }

        }else{
            logger.warn("验证码错误");
            resp.sendRedirect("/login?code=1001");
        }
    }
}
