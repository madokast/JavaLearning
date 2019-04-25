package madokast;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap s = new LinkedHashMap();
        //双向链表实现的，迭代时性能好
        s.put("A",80);
        s.put("B",82);
        s.put("C",76);
        System.out.println("s = " + s);

        s.forEach((key,value)->
        {
            System.out.println(key+"-->"+value);
        });

        //s = {A=80, B=82, C=76}
        //A-->80
        //B-->82
        //C-->76
    }
}
