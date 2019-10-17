package com.zrx;

import org.apache.log4j.lf5.util.ResourceUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericP {
    @Test
    public void test()throws Exception{
        final Class<?> clazz = Class.forName("com.zrx.dao.IUserDao");

        final Method method = clazz.getMethods()[0];

        final Type genericReturnType = method.getGenericReturnType();

        System.out.println(genericReturnType);// java.util.List<com.zrx.domain.User>

        if(genericReturnType instanceof ParameterizedType){
            final Class actualTypeArgument = (Class) ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
            System.out.println(actualTypeArgument);//class com.zrx.domain.User

            System.out.println(actualTypeArgument.getName());// com.zrx.domain.User
        }
    }
}
