package com.it.chaoxu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by dell on 2016/6/14.
 */
@WebServlet("/pay")
public class payServlet extends HttpServlet {
private static Logger logger = LoggerFactory.getLogger(payServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = UUID.randomUUID().toString();
        //放入表单
        req.setAttribute("token",token);
        //放入session
        HttpSession session = req.getSession();
        session.setAttribute("token",token);

        req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从表单中获取token
        String token = req.getParameter("token");
        //2.从session中获取token
        HttpSession session = req.getSession();
        String sessiontoken = (String)session.getAttribute("token");
        //3. 判断表单中的token和session中的token是否一致
        if(token!=null&&token.equals(sessiontoken)){
            //将session中的token删除
            session.removeAttribute("token");
            String money  = req.getParameter("money");
            logger.info("成功支付{}元",money);
            req.getRequestDispatcher("WEB-INF/views/paycs.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("WEB-INF/views/payerro.jsp").forward(req,resp);
        }

    }
}
