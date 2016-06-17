package com.it.chaoxu.service;

import com.it.chaoxu.dao.Userdao;
import com.it.chaoxu.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dell on 2016/6/14.
 */
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final String salt = "#^(*&^^%*&&*&^%^$%#$&^&*%^";
    private Userdao dao = new Userdao();
    /**
     * 用户登录
     * @param username 账号
     * @param password 密码
     * @return 如果登录成功则返回user对象 登录失败则返回null
     */
    public User login(String username, String password){
        final User user = dao.queryonebyname(username);
        if(user!=null&&user.getPassword().equals(DigestUtils.md5Hex(password+salt))){
            logger.debug("{}登录成功",user);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //EmailUtil.sendEmail(user.getAddress(),"周五下午四点通知员工开会","开会时间等待通知");
                }
            }).start();
            return user;
        }else{
            return null;
        }

    }
}
