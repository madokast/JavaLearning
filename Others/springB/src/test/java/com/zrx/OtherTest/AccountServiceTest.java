package com.zrx.OtherTest;

import com.zrx.cofig.SpringConfig;
import com.zrx.demo.Account;
import com.zrx.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        final IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        final List<Account> all = accountService.findAll();

        System.out.println("all = " + all);
    }

    @Test
    public void testFindAll2(){

        final List<Account> all = accountService.findAll();

        System.out.println("all = " + all);
    }
}
