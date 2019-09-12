package com.smart.service;

import java.util.Date;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.smart.domain.User;

@ContextConfiguration("classpath*:/smart-context.xml") // 启动spring 容器

//2019年9月11日 测试时默认回滚，气死了

//@Rollback(value = false) //不回滚
@Rollback(value = true)  // 改成回滚
@Transactional(transactionManager = "transactionManager")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","11111");
        Assert.assertTrue(b1);
        Assert.assertFalse(b2);
    }

    @Test
    public void testFindUserByUserName()throws Exception{
        for(int i =0; i< 100;i++) {
            User user = userService.findUserByUserName("admin");
            Assert.assertEquals(user.getUserName(), "admin");
        }
    }

    @Test
    public void testAddLoginLog() {
        try {
            User user = userService.findUserByUserName("admin");

            user.setLastIp("192.168.12.7");
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
        }catch (Exception e){e.printStackTrace();}
    }


}
