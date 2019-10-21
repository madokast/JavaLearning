package com.zrx.OtherTest;

import com.zrx.dao.IAccountDao;
import com.zrx.demo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class TestAccountDaoJdbcTemplate {
    @Autowired
    private IAccountDao accountDaoJdbcTemplate;

    @Test
    public void test1(){
        final List<Account> all = accountDaoJdbcTemplate.findAll();
        System.out.println("all = " + all);
    }
}
