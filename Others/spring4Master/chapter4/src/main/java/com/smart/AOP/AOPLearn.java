package com.smart.AOP;

import org.springframework.stereotype.Component;

import javax.sql.rowset.Predicate;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class AOPLearn {
    public void aopCGLib(){
        CgLibProxy proxy = new CgLibProxy();
        Person person = (Person) proxy.getProxy(Person.class);
        person.setName("miao");
        person.say();
    }


    public void aopJDK(){
        final Person person = new Person();
        person.setName("zrx");
        person.say();
        System.out.println("person.getClass() = " + person.getClass());

        Sayable person_X = (Sayable)Proxy.newProxyInstance(Person.class.getClassLoader(), Person.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("花花花花");
                final Object invoke = method.invoke(person, args);
                System.out.println("花花花花");

                return invoke;
            }
        });

        System.out.println("person_X.getClass() = " + person_X.getClass());
        person_X.say();
    }
}
