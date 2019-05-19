package Collection.List;

import java.util.LinkedList;

/**
 * vector 集合 同步的 单线程 慢
 * 奇怪的迭代器
 */
public class linkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println("linkedList = " + linkedList);
        linkedList.push("d");
        linkedList.push("e");//push放在头部
        System.out.println("linkedList = " + linkedList);
        linkedList.addFirst("z");
        linkedList.addFirst("y");
        System.out.println("linkedList = " + linkedList);
        linkedList.pop();
        linkedList.pop();
        System.out.println("linkedList = " + linkedList);


    }
}
//D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50425:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.List.linkedListTest
//linkedList = [a, b, c]
//linkedList = [e, d, a, b, c]
//linkedList = [y, z, e, d, a, b, c]
//linkedList = [e, d, a, b, c]
//
//Process finished with exit code 0