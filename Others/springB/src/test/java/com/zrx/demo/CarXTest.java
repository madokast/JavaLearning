package com.zrx.demo;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CarXTest {
    private CarX carX;

    @Autowired
    public void setCarX(CarX carX) {
        this.carX = carX;
    }

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CarX.class);
        final CarX carX = applicationContext.getBean("carX", CarX.class);
        System.out.println(carX);

        applicationContext.close();


    }
}
