package Collection.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 * HashSet中就是 new 一个HashMap，只是不使用Key功能
 * 无序结构
 *
 * LinkedHashMap
 * 多一个链表存储顺序
 */
public class Test {
    public static void main(String[] args) {
        //Comparable c;// public int compareTo(T o);
        //Comparator cc;
        System.out.println("Integer.valueOf(2).compareTo(1) = " +
                Integer.valueOf(2).compareTo(1));//1?
        //Integer.valueOf(2).compareTo(1) = 1

        Map<String,String> map = new HashMap<>();
        map.put("a","ABC");
        map.put("b","BBB");
        map.put("c","COS");
        System.out.println("map = " + map);
        //map = {a=ABC, b=BBB, c=COS}
        System.out.println("-----------------------");

        System.out.println("map.keySet() = " + map.keySet());
        System.out.println("map.values() = " + map.values());
        //map.keySet() = [a, b, c]
        //map.values() = [ABC, BBB, COS]

        System.out.println("map.entrySet() = " + map.entrySet());
        //map.entrySet() = [a=ABC, b=BBB, c=COS]


    }
}
