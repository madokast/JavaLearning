package com.zrx.cgilbTest;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class ProxyTest {
    @Test
    public void test() {
        final Person person = new Person();
        person.sayHello();

        System.out.println("------------------");

        final Log log = new Log();

        Person personProxy = (Person) Enhancer.create(Person.class, new MethodInterceptor() {
            public Object intercept(Object proxy,
                                    Method method,
                                    Object[] args, MethodProxy methodProxy) throws Throwable {
                log.log(method.getName());
                final Object invoke = method.invoke(person, args);
                log.log(method.getName());
                return invoke;
            }
        });


        personProxy.sayHello();

    }
}
