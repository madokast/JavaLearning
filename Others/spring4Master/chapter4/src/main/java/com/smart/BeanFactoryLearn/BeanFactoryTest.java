package com.smart.BeanFactoryLearn;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
public class BeanFactoryTest {
    public void test(){
        final PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        final Resource resource = resolver.getResource("classpath:carBean.xml");

        try {
            System.out.println(resource.getURL());
            //file:/D:/Documents/GitHub/JavaLearning/Others/spring4Master/chapter4/target/classes/carBean.xml
        }catch (Exception e){e.printStackTrace();}

        final DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        System.out.println("init BeanFactory");

        Car car = factory.getBean("car01",Car.class);

        car.introduce();

        //init BeanFactory
        //Car{brand='红旗', color='黑色', speed=200.0}

    }
}
