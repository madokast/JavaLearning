package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 454 反射
 * 框架设计的灵魂
 * 什么是框架？
 *      本成品的软件
 * 在框架的基础上的开发，可以简化编码
 *
 * 概念： 将类的各个组成部分封装为其他对象
 *  反射机制
 * 可以解耦，提高程序可扩展性
 *
 * Source 源代码阶段
 * load
 * Runtime 运行时阶段
 *
 * 455 456 457 458
 *
 * 459
 * class对象获取方式
 *  1.没有进入内存。则使用Class.forName
 *  2.进入内存了。类名.class
 *  3.有对象了。object.getClass()
 *
 */

public class Test {
    public static void main(String[] args) throws Exception{
        final Class<?> classPerson = Class.forName("reflect.Person");

        //instance
        final Constructor<?>[] constructors = classPerson.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println("constructor = " + constructor);
        }

        final Constructor<?> constructor = classPerson.getConstructor(String.class, int.class);
        final Object madokast = constructor.newInstance("madokast", 18);
        System.out.println("madokast = " + madokast);

        System.out.println("----------------");

        //field
        final Field[] fields = classPerson.getFields();
        for(Field field:fields){
            System.out.println("field = " + field);
        }
        System.out.println("-----------");

        final Field[] declaredFields = classPerson.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println("field = " + field);
        }

        System.out.println("------------");

        //method
        final Method[] methods = classPerson.getMethods();
        for(Method method:methods){
            System.out.println("method = " + method);
        }

        final Method getName = classPerson.getMethod("getName");
        final Object invokeed = getName.invoke(madokast, null);
        System.out.println("invokeed = " + invokeed);

        final Method setAge = classPerson.getMethod("setAge", int.class);
        setAge.invoke(madokast,14);
        System.out.println(madokast);
        setAge.setAccessible(true);

        //field
        final Field name = classPerson.getDeclaredField("name");
        name.setAccessible(true);
        name.set(madokast,"miao!");
        System.out.println("madokast = " + madokast);


        //classLoader
        final ClassLoader classLoader = classPerson.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        //classLoader = jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

    }
}
