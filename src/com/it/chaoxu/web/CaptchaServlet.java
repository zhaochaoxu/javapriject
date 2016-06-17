package com.it.chaoxu.web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by dell on 2016/6/14.
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CaptchaServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成验证码
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(67, 78, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        RandomWordFactory rw = new RandomWordFactory();
        rw.setMaxLength(3);
        rw.setMinLength(3);
        cs.setWordFactory(rw);
        OutputStream os = resp.getOutputStream();//输入到网页上
        String captcha= EncoderHelper.getChallangeAndWriteImage(cs,"png",os);
        //将验证码放入session
        HttpSession session = req.getSession();
        session.setAttribute("captcha",captcha);
        logger.debug("captcha: {}",captcha);
        os.flush();
        os.close();



    }
}
