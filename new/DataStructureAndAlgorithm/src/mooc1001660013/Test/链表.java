package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.LinkedListMooc;
import mooc1001660013.ListSeriesMooc.ListMooc;

import java.util.stream.Stream;

public class 链表 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test13();
//        test4();
//        test5();
        test6();
    }

    private static void test6() {
        ListMooc listMooc = new LinkedListMooc();
        Stream.generate(Math::random).limit(20).forEach(e->listMooc.insert((int)(e*10)));
        System.out.println(listMooc.size());
        listMooc.print();

        System.out.println(listMooc.isSorted());
        listMooc.sortBubble();
        listMooc.print();
    }

    private static void test5() {
        ListMooc listMooc = new LinkedListMooc();
        listMooc.insert(2);
        listMooc.insert(2);
        listMooc.insert(2);
        listMooc.insert(2);
        listMooc.print();

        listMooc.set(100,3);
        listMooc.print();

        listMooc.set(-200,0);
        listMooc.print();
    }

    private static void test4() {
        ListMooc listMooc = new LinkedListMooc();
        listMooc.insert(2);
        listMooc.print();

        listMooc.insert(3,listMooc.size());
        listMooc.print();

        listMooc.delete();
        listMooc.print();

        listMooc.insert(200);
        listMooc.print();
        listMooc.delete(1);
        listMooc.print();

        listMooc.insert(1000);
        listMooc.print();
        listMooc.delete(0);
        listMooc.print();

    }

    private static void test13() {
        ListMooc listMooc = new LinkedListMooc();
        Stream.generate(Math::random).limit(20).forEach(e->listMooc.insert((int)(e*10)));
        System.out.println(listMooc.size());
        listMooc.print();

        listMooc.insert(100,3);
        listMooc.print();
        System.out.println(listMooc.size());

        listMooc.insert(-100,listMooc.size()-1);
        listMooc.print();
    }

    private static void test2() {
        ListMooc listMooc = new LinkedListMooc();
        int size = 10;
        Stream.generate(Math::random).limit(size).forEach(e->listMooc.insert((int)(e*20)));
        System.out.println(listMooc.size());
        System.out.println(listMooc);

        for (int i = 0; i < listMooc.size(); i++) {
            System.out.println(listMooc.get(i));
        }
    }

    private static void test1() {
        ListMooc listMooc = new LinkedListMooc();
        System.out.println(listMooc.size());
        System.out.println(listMooc);

        listMooc.insert(1);
        System.out.println(listMooc.size());
        System.out.println(listMooc);

        System.out.println(listMooc.get(0));
    }
}
