package com.zrx;

import com.zrx.dao.IUserDao;
import com.zrx.domain.User;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class InterfaceImplementTest {
    @Test
    public void test()throws Exception{
        final Class<?> IUserDaoClass = Class.forName("com.zrx.dao.IUserDao");

        Object userDao = Proxy.newProxyInstance(IUserDaoClass.getClassLoader(), new Class[]{IUserDaoClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("findAll")){
                            List<User> list = new ArrayList<User>();
                            User user = new User();
                            user.setUsername("InterfaceImplementTest");
                            list.add(user);
                            return list;
                        }
                        return null;
                    }
                });

        final Method findAllMethod = IUserDaoClass.getMethod("findAll");

        final Object invokeResult = findAllMethod.invoke(userDao);

        final List<User> all = (List)invokeResult;

        System.out.println(all);
    }
}
