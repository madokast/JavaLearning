package com.zrx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Service("enhanceClass")
@Aspect//表示当前类需要切面
public class EnhanceClass{
    @Pointcut("execution(public int com.zrx.service.impl.ARuServiceImpl.methodNeedEnhance())")
    public void methodNeedEnhance(){

    }

    @Before("methodNeedEnhance()")
    public void frontEnhance(){
        System.out.println("前置增强");
    }

    @AfterReturning("methodNeedEnhance()")
    public void afterEnhance(){
        System.out.println("后置增强");
    }

    @AfterThrowing("methodNeedEnhance()")
    public void exceptionEnhance(){
        System.out.println("异常增强");
    }

    @After("methodNeedEnhance()")
    public void finallyEnhance(){
        System.out.println("最终增强");
    }

    @Around("execution(public void com.zrx.service.impl.ARuServiceImpl.methodNeedAroundEnhance())")
    public void aroundEnhance(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("环绕前");
            proceedingJoinPoint.proceed();
            System.out.println("环绕后");
        }catch (Throwable e){
            System.out.println("环绕异常");
            e.printStackTrace();
        }finally {
            System.out.println("环绕最终");
        }
    }
}
