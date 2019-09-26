package com.smart.AOP;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GreetingBeforeAdvice implements MethodBeforeAdvice  {
    /**
     * 方法前切入
     * @param method 目标类的方法
     * @param objects 入参
     * @param o 目标类实例
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String)objects[0];
        System.out.println("How are you! Mr." + name);
    }
}
