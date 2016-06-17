package com.it.chaoxu.Util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dell on 2016/6/15.
 */
public class EmailUtil {
    private static HtmlEmail email = new HtmlEmail();
    private  static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
    /**
     * 发送html邮件
     * @param toaddress 收件人地址
     * @param subject 邮件的主题
     * @param html 邮件的格式
     */
    public static void sendEmail(String toaddress,String subject,String html) {
        email.setHostName(config.get("email.HostName"));
        email.setAuthentication(config.get("email.username"),config.get("email.password"));
        email.setSmtpPort(new Integer(config.get("email.port")));
        email.setCharset(config.get("email.charset"));

        try {
            email.setFrom(config.get("email.from"));
            email.setSubject(subject);
            email.addTo(toaddress);
            email.setHtmlMsg(html);
            email.send();
            logger.debug("邮件发送成功到{}",toaddress);
        } catch (EmailException e) {
            logger.error("邮件发送异常");
            throw new RuntimeException("邮件发送失败",e);
        }
    }
}
