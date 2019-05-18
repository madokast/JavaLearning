package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合目标
 * 存储集合
 * 集合特性
 * 遍历集合
 * List集合 有序集合
 * Set集合 不重复 没有索引
 *
 * collection常用方法
 * add
 * clear
 * remove
 * contains
 * isEmpty
 * size
 * toArray
 */
public class Text {
    public static void main(String[] args) {
        text();
        System.out.println("------------------");
        iteratorTest();


    }

    /**
     * 迭代器有泛型，跟走集合走
     * 迭代器是集体集合的内部类
     */
    private static void iteratorTest() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(3);

        System.out.println("collection = " + collection);
        Iterator<Integer> iteratorIterator = collection.iterator();
        while(iteratorIterator.hasNext())
            System.out.print(iteratorIterator.next()+"\t");
        //collection = [1, 2, 3, 3]
        //10
        //11
        //12
        //12

        System.out.println();
        for (Integer integer : collection) {
            System.out.println("integer = " + integer);
        }
    }

    private static void text() {
        Collection<String> collection = new ArrayList<>();
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
        collection.add("123");
        collection.add("123");
        collection.add("abc");
        collection.add("一二三");
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.isEmpty() = " + collection.isEmpty());
        //collection.isEmpty() = true
        //collection.size() = 4
        //collection.isEmpty() = false

        System.out.println("---------------------");

        System.out.println("collection = " + collection);
        System.out.println("collection.remove(\"321\") = " + collection.remove("321"));
        System.out.println("collection.size() = " + collection.size());
        System.out.println("collection.remove(\"123\") = " + collection.remove("123"));
        System.out.println("collection = " + collection);
        System.out.println("collection.size() = " + collection.size());
        //collection = [123, 123, abc, 一二三]
        //collection.remove("321") = false
        //collection.size() = 4
        //collection.remove("321") = true
        //collection = [123, abc, 一二三]
        //collection.size() = 3

        System.out.println("collection.contains(\"123\") = " + collection.contains("123"));
    }
}
