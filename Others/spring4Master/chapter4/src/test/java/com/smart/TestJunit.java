package com.smart;

import com.smart.AOP.AOPLearn;
import com.smart.BeanFactoryLearn.BeanFactoryTest;
import com.smart.ResourceLearn.ResourceLearn;
import com.smart.UserBeanTest.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // //使用junit4进行测试
@ContextConfiguration(locations = "classpath:smart-context.xml") // 没有会出问题
public class TestJunit {
//    @Autowired
    private ResourceLearn resourceLearn;
//    @Autowired
    private BeanFactoryTest beanFactoryTest;

//    @Autowired
    private User zrxUser;
//    @Autowired
    private User miaoUser;

    @Autowired
    private AOPLearn aopLearn;

    @Test
    public void aopLearnTest(){
        aopLearn.aopJDK();
        System.out.println("+++++++++++++++++++++++++");
        aopLearn.aopCGLib();
    }

    @Test
    public void userBeanTest(){
        zrxUser.sayHello();
        miaoUser.sayHello();
    }

    @Test
    public void BeanFactoryTestTest(){
        beanFactoryTest.test();
    }

    //@Test
    public void ResourceLearnTest(){ resourceLearn.learn(); }

    //@Test
    public void testDome(){
        Assert.assertTrue(true);
    }

    //@Test
    public void errTest(){
        System.err.println("测试成功？！");
    }

    @org.junit.Before
    public void before(){ System.out.println("----------------"); }
    @org.junit.After
    public void after(){ System.out.println("----------------"); }

}
