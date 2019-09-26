package com.smart;

import com.smart.AOP.Waiter;
import com.smart.SpELTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // //使用junit4进行测试
@ContextConfiguration(locations = "classpath:smart-context.xml")
public class SpELTest {

}
