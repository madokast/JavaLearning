package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewInJava9 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        System.out.println("list = " + list);
        System.out.println("list.getClass() = " + list.getClass());
        //list = [1, 2, 3, 4]
        //list.getClass() = class java.util.ImmutableCollections$ListN

        Map<String,Integer> map = Map.of("a",1,"b",2);
        System.out.println("map = " + map);
        System.out.println("map.getClass() = " + map.getClass());
        //map = {b=2, a=1}
        //map.getClass() = class java.util.ImmutableCollections$MapN

    }
}
