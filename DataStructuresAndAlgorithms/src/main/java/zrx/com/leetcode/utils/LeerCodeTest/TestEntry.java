package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyRequire;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * 测试入口
 * <p>
 * Data
 * 2019/11/10 15:54
 *
 * @author zrx
 * @version 1.0
 */

public class TestEntry {
    private Object solution;
    private String methodName;
    private Class[] parameters;

    public static TestEntry getInstance(Class solutionClass){
        Class  outClass = solutionClass.getEnclosingClass();
        final Constructor[] constructors = solutionClass.getConstructors();
        if(constructors.length!=1){
            MyRequire.throwRunTimeException("TestEntry:Question内部类Solution构造器不唯一");
        }

        final Method[] methods = solutionClass.getMethods();
        Method testMethod = null;
        int testMethodNumber = 0;
        for (Method method : methods) {
            if(!otherMethods.contains(method.getName())){
                testMethod = method;
                testMethodNumber++;
            }
        }

        if(testMethod == null){
            MyRequire.throwRunTimeException("TestEntry:Question内部类Solution没有公共测试方法");
        }
        if(testMethodNumber!=1){
            MyRequire.throwRunTimeException("TestEntry:Question内部类Solution公共方法不唯一");
        }


        Object newInstance = null;
        try {
            newInstance = constructors[0].newInstance(outClass.getConstructors()[0].newInstance());
        }catch (Exception e){
            MyRequire.throwRunTimeException("TestEntry:Question内部类Solution没有无参构造器");
        }


        return getInstance(newInstance,testMethod.getName(),testMethod.getParameterTypes());
    }

    public static TestEntry getInstance(Object solution,String methodName,Class...parameters){
        return new TestEntry(solution,methodName,parameters);
    }

    private TestEntry(Object solution, String methodName, Class[] parameters) {
        this.solution = solution;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public Object getSolution() {
        return solution;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getParameters() {
        return parameters;
    }

    private static Set<String> otherMethods = new HashSet<>();
    static  {
        otherMethods.add("wait");
        otherMethods.add("equals");
        otherMethods.add("toString");
        otherMethods.add("hashCode");
        otherMethods.add("getClass");
        otherMethods.add("notify");
        otherMethods.add("notifyAll");
    }
}
