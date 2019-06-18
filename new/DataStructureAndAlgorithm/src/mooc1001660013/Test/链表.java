package mooc1001660013.Test;

import mooc1001660013.LinkedListMooc;
import mooc1001660013.ListMooc;

import java.util.stream.Stream;

public class 链表 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test13();
    }

    private static void test13() {

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
