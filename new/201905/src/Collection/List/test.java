package Collection.List;

import java.util.*;

/**
 * 有序 索引
 * 包含索引的方法
 * add
 * gat
 * set
 * remove
 *
 * ArrayList 实现不同步？
 * 添加元素是每次产生一个数组
 *
 * LinkedList 实现不同步 - 多线程
 * 双向链表
 * addFirst
 * addLast
 * removeFirst
 * removeLat
 * getFirst
 * getList
 *
 */
public class test {
    public static void main(String[] args) {
        operate(new ArrayList<String>());
        operate(new LinkedList<String>());
        operate(new Vector<String>());
        operate(new Stack<String>());
//        operate(new <String>());

    }

    public static void operate(List<String> list){
        System.out.println("get a "+list.getClass());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("list = " + list);
        list.add(0,"z");
        System.out.println("list = " + list);
        list.set(1,"y");
        System.out.println("list = " + list);
        list.remove(4);
        System.out.println("list = " + list);
        System.out.println("list.get(3) = " + list.get(3));//c
        System.out.println("----------------\n");
    }
}

//D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50370:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.List.test
//get a class java.util.ArrayList
//list = [a, b, c, d]
//list = [z, a, b, c, d]
//list = [z, y, b, c, d]
//list = [z, y, b, c]
//list.get(3) = c
//----------------
//
//get a class java.util.LinkedList
//list = [a, b, c, d]
//list = [z, a, b, c, d]
//list = [z, y, b, c, d]
//list = [z, y, b, c]
//list.get(3) = c
//----------------
//
//
//Process finished with exit code 0