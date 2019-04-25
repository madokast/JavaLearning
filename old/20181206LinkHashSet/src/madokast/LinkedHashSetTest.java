package madokast;
/*LinkedHashSet is a son class of HashSet
* like HashSet, it also store elements where their Hash code
* but the LinkedHashSet can sustain the order of elements by a linked list
* so the cost is high than HashSet but when transverse all elements the LinkedHashSet is faster
* */

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("abc");
        lhs.add("def");
        lhs.add("xyz");

        System.out.println("lhs = " + lhs);//lhs = [abc, def, xyz]

        lhs.remove("abc");
        System.out.println("lhs = " + lhs);//lhs = [def, xyz]


    }
}
