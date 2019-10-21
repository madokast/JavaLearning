package com.zrx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void test(){
        accountService.transfer("aaa","bbb",-111F);
        System.out.println(accountService.findAll());
    }
}
