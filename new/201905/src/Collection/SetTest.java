package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * set集合
 * 元素不重复
 * 没有索引
 * 不能用普通for循环
 *
 * 实现类
 * HashSet 不保证顺序 查询速度块
 *
 * 哈希表 = 数组+链表/红黑树，同一hash值的元素链表
 * 数组初始长度16
 * 当链表长度超过8位，就会转化为红黑树
 *
 * 不允许重复元素
 *
 * 第二个实现类
 * LinkedHashSet 可预知迭代顺序
 * 继承了HashSet
 * 底层是Hash表，再加上一层链表，用来记录元素的存取顺序
 */
public class SetTest {
    public static void main(String[] args) {
        hashSetTest();
        hash();
        linkedHashSetTest();
    }

    public static void linkedHashSetTest(){
        //public class LinkedHashSet<E>
        //    extends HashSet<E>
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    }

    public static void hash(){
        System.out.println("通话".hashCode());
        System.out.println("重地".hashCode());
        //1179395
        //1179395

        Set<String> set = new HashSet<>();
        set.add("通话");
        set.add("重地");
        for (String s : set) {
            System.out.println("s = " + s);
        }

        //hash冲突，但是equals不同
    }

    public static void hashSetTest(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);
        for (Integer integer : set) {
            System.out.println("integer = " + integer);
        }
        //D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50436:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.SetTest
        //integer = 1
        //integer = 2
        //integer = 3
        //integer = 4
        //
        //Process finished with exit code 0
    }
}
