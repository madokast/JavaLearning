package com.zrx;

import com.zrx.demo.Account;
import com.zrx.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        final IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        final List<Account> all = accountService.findAll();

        System.out.println("all = " + all);
    }
}
