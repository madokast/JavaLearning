package com.smart.AOP;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {
    private Enhancer enhancer  = new Enhancer();
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = null;

        if(method.getName().equals("say")){
            System.out.println("花花花花");

            result = methodProxy.invokeSuper(o,objects);

            System.out.println("花花花花");
        }else {
            result = methodProxy.invokeSuper(o,objects);
        }




        return result;
    }
}
