package zrx;

import MyCollection.AbstractCollectionZRX;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
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
        AbstractList abstractList;

//        listIteratorTest();
        arrayTest();
    }

    public static void arrayTest(){
        int[] ints = new int[5];
        String[] strings = new String[2];

        System.out.println("ints.getClass() = " + ints.getClass());
        System.out.println("ints.getClass().getComponentType() = " + ints.getClass().getComponentType());

        System.out.println("strings.getClass() = " + strings.getClass());
        System.out.println("strings.getClass().getComponentType() = " + strings.getClass().getComponentType());

        String[] strings2 = (String[]) Array.newInstance(String.class,10);
        strings2[0] = "123";
        for (String s : strings2) {
            System.out.println("s = " + s);
        }

        int[] ints2 = (int[]) Array.newInstance(int.class,10);

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
