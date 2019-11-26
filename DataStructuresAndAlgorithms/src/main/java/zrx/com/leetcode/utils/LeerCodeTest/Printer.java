package zrx.com.leetcode.utils.LeerCodeTest;

import zrx.com.leetcode.utils.MyArrayTools;

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
    }

    public static String print(Class clazz,Object o){

        return map.getOrDefault(clazz,Object::toString).fun(o);
    }
}
