package com.zrx.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CarTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        final Object car = applicationContext.getBean("car");
        System.out.println("car = " + car);
    }
}
