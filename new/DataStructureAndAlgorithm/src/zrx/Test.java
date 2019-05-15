package zrx;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        Iterator it;
        Collection c;
        AbstractCollection ac;
        List l;
        ArrayList A;
        ListIterator listIterator;
        Iterable i;

        listIteratorTest();
    }

    public static void listIteratorTest(){
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list.size() = " + list.size());//list.size() = 4

        for (int i = 0; i < list.size(); i++) {
            System.out.println("i list.get(i) = "+ i +" " + list.get(i));
            //i list.get(i) = 0 0
            //i list.get(i) = 1 1
            //i list.get(i) = 2 2
            //i list.get(i) = 3 3
        }

        ListIterator listIterator = list.listIterator();
        System.out.println("listIterator.next() = " + listIterator.next());//0
        System.out.println("listIterator.next() = " + listIterator.next());//1

        //      0   1   2   3
        //    |  |   |   |   |
        System.out.println("listIterator.nextIndex() = " + listIterator.nextIndex());//2
        System.out.println("listIterator.previousIndex() = " + listIterator.previousIndex());//1


    }
}
