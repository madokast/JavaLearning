package AnnotationTest.test01;

import java.lang.reflect.Method;

/**
 * 注解的意义来了~~~
 */

public class TestCheck {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        final Class<? extends Calculator> aClass = c.getClass();
        final Method[] methods = aClass.getMethods();

        int bugNum = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(Method method:methods){
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                }catch (Exception e){
                    bugNum++;
                    stringBuilder.append("--------------------\n");
                    stringBuilder.append("方法名："+method.getName()+"\n");
                    stringBuilder.append("原因："+e.getCause()+"\n");
                    stringBuilder.append("信息："+e.getMessage()+"\n");
                }
            }
        }

        System.out.println("出现"+bugNum+"个异常，详细信息如下");
        System.out.println(stringBuilder.toString());
    }

}
