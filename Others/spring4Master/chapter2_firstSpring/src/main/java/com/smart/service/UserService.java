package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 标注为服务层的bean
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName,String password){
        final int matchCount = userDao.getMatchCount(userName, password);
        return matchCount>0;
    }

    public User findUserByUserName(String username){
        return userDao.findUserByUserName(username);
    }

    @Transactional //让此方法运行在事务环境中
    public void loginSuccess(User user){
        //user积分增加 5
        user.setCredits(user.getCredits()+5);

        //更新这个user
        userDao.updateLoginInfo(user);

        //login create
        LoginLog loginLog = new LoginLog();
        //    private int loginLogId;
        //    private int userId;
        //    private String ip;
        //    private Date loginDate;

        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());


        //log it
        loginLogDao.insertLoginLog(loginLog);
    }
}
