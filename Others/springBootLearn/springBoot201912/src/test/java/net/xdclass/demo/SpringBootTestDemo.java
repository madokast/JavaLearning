package net.xdclass.demo;

import junit.framework.TestCase;
import net.xdclass.demo.application.DemoApplication;
import net.xdclass.demo.controller.InjectController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 * 测试类
 * <p>
 * Data
 * 2019/12/16 12:01
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class) //底层为junit 即 SpringJUnit4ClassRunner
@SpringBootTest(classes = {DemoApplication.class}) //启动整个spring boot 工程
public class SpringBootTestDemo {

    @Autowired
    InjectController injectController;

    @Test
    public void test(){
        System.out.println("injectController.inject() = " + injectController.inject());

    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }



}
