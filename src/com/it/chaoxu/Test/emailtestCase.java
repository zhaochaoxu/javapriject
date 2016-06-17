package com.it.chaoxu.Test;

import com.it.chaoxu.Util.EmailUtil;
import com.it.chaoxu.dao.Userdao;
import com.it.chaoxu.entity.User;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dell on 2016/6/14.
 */
public class emailtestCase {
    Logger logger = LoggerFactory.getLogger(emailtestCase.class);
    @Test
    public void testEmail(){
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("zhaoxu031428","zcx0314");
        email.setSmtpPort(25);
        email.setCharset("utf-8");
        try{
            email.setFrom("zhaoxu031428@163.com");
            email.setSubject("这是一份邮件");
            email.setHtmlMsg("<h1 style='color:red'>合同内容见附件</h1>");//<img src='http://ww1.sinaimg.cn/mw690/824de770jw1epwcnivby6j20go0p00x4.jpg'>");
            email.addTo("719595716@qq.com");
            email.send();
        }catch (EmailException e){
            e.printStackTrace();
            throw new RuntimeException("邮件发送失败",e);
        }
    }
    Userdao dao= new Userdao();
    User u = dao.queryonebyname("zcx");
    @Test
    public void testmail(){
        logger.debug("数据库的名字{}",u);
        EmailUtil.sendEmail(u.getAddress(),"通知明天下午三点开会","会议内容今天下午商议");
    }
}
