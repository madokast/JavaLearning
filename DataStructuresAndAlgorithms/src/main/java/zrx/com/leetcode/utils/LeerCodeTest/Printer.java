package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * 打印器
 * <p>
 * Data
 * 2019/11/10 16:36
 *
 * @author zrx
 * @version 1.0
 */

public class Printer {
    private static Map<Class,ToString> map = new HashMap<>();
    static  {
        map.put(int[].class,MyArrayTools::intArrayToString);
        map.put(String[].class,o->Arrays.toString((Object[])o));
    }

    public static String print(Class clazz,Object o){

        return map.getOrDefault(clazz,Object::toString).fun(o);
    }

    public static String print(Object o){
//        System.out.println(o+"测试>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return print(o.getClass(),o);
    }

    public static String print(Object[] objects){
        if(objects==null)
            return "null";

        if(objects.length==1)
            return print(objects[0]);

        StringBuilder sb =new StringBuilder();
        sb.append("[");

        for (int i = 0; i < objects.length - 1; i++) {
            sb.append(print(objects[i]));
            sb.append(", ");
        }

        sb.append(print(objects[objects.length-1]));

        sb.append("]");

        return sb.toString();
    }
}
