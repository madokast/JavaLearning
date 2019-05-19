package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * addAll(c,e...)
 * shuffle(list)
 * sort(list,comparator)
 */

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        System.out.println("list = " + list);

        Collections.sort(list);
        System.out.println("list = " + list);

        Collections.shuffle(list);
        System.out.println("list = " + list);

        Collections.sort(list,(a,b)->a<b? 1:
                (a>b?-1:0));
        System.out.println("list = " + list);
        //D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50515:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.CollectionsTest
        //list = [2, 3, 4, 1]
        //list = [1, 2, 3, 4]
        //list = [3, 1, 4, 2]
        //list = [4, 3, 2, 1]
        //
        //Process finished with exit code 0
    }
}
