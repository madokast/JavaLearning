package com.smart;

import com.smart.JdbcTemplateTest.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.parsers.FactoryConfigurationError;

@RunWith(SpringJUnit4ClassRunner.class) // //使用junit4进行测试
@ContextConfiguration(locations = "classpath:smart-context.xml")
@Rollback(false)
public class JdbcTest {
    @Autowired
    private Test jdbcTest;

    @org.junit.Test
    public void test(){
        jdbcTest.test();
    }

    @org.junit.Before
    public void before(){ System.out.println("----------------"); }
    @org.junit.After
    public void after(){ System.out.println("----------------"); }


}
