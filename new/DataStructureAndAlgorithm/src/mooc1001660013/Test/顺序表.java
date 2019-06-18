package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.ArrayListMooc;

import java.util.stream.Stream;

public class 顺序表 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        int size = 50;
        ArrayListMooc arrayListMooc = new ArrayListMooc(size);
        Stream.generate(Math::random).limit(size).forEach(e->arrayListMooc.insert((int)(e*20)));
        ArrayListMooc arrayListMoocBin = new ArrayListMooc(size);
        arrayListMoocBin.zeros();
        arrayListMoocBin.print();
        int j = 0,k = size-1;
        for (int i = 0; i < size; i++) {
            int e = arrayListMooc.get(i);
            if(e>9)
                arrayListMoocBin.set(e,j++);
            else
                arrayListMoocBin.set(e,k--);
        }
        arrayListMooc.print();
        arrayListMoocBin.print();
    }

    private static void test3() {
        int size = 50;
        ArrayListMooc arrayListMooc = new ArrayListMooc(size);
        Stream.generate(Math::random).limit(size).forEach(e->arrayListMooc.insert((int)(e*20)));
        arrayListMooc.print();
        arrayListMooc.sortBubble();
        arrayListMooc.print();
        System.out.println(arrayListMooc.search(3));
        System.out.println(arrayListMooc.get(arrayListMooc.search(3)));
        System.out.println(arrayListMooc.searchBinary(2));
        System.out.println(arrayListMooc.get(arrayListMooc.searchBinary(2)));
    }

    private static void test2() {
        ArrayListMooc arrayListMooc  = new ArrayListMooc(10);
        arrayListMooc.insert(2);
        arrayListMooc.insert(4);
        arrayListMooc.insert(1);
        arrayListMooc.insert(6);
        System.out.println(arrayListMooc.size());
        arrayListMooc.print();
        System.out.println(arrayListMooc.isSorted());

        arrayListMooc.sortBubble();
        arrayListMooc.print();
    }

    private static void test1() {
        ArrayListMooc arrayListMooc = new ArrayListMooc(10);
        arrayListMooc.insert(1);
        arrayListMooc.insert(2);
        arrayListMooc.insert(3);
        arrayListMooc.print();

        arrayListMooc.insert(4,0);
        arrayListMooc.print();

        arrayListMooc.delete(1);
        arrayListMooc.print();

        arrayListMooc.delete();
        arrayListMooc.print();

        System.out.println(arrayListMooc.get(0));
        System.out.println(arrayListMooc.get(1));

        System.out.println(arrayListMooc.search(2));
        System.out.println(arrayListMooc.search(1));

        System.out.println(arrayListMooc.isSorted());
    }
}
