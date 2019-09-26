package com.smart;

import com.smart.BeanFactoryLearn.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppContext {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("carBean.xml");

        final Car car01 = (Car)applicationContext.getBean("car01");
        car01.introduce();

        ((ClassPathXmlApplicationContext)applicationContext).refresh();

        java.beans.PropertyEditor editor;
    }
}
