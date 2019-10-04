package com.smart;


import com.smart.cacheLearn.CacheSpring;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // //使用junit4进行测试
@ContextConfiguration(locations = "classpath:smart-context.xml")
public class CacheTest {
    @Autowired
    private CacheSpring cacheSpring;

    @Test
    public void test(){
        for (int i = 0; i < 3; i++) {
            System.out.println(cacheSpring.getByID(i));
        }

        System.out.println(cacheSpring.getByID(2));
        System.out.println(cacheSpring.getByID(0));
    }

    @Before
    @After
    public void ba(){
        System.out.println("----------------");
    }
}
