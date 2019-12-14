package zrx.com.others;

import zrx.com.MultiThread.MyTools;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Description
 * test
 * <p>
 * Data
 * 2019/11/27 22:04
 *
 * @author zrx
 * @version 1.0
 */

public class Test {
    @org.junit.Test
    public void test01() {
        int x = 3;
        if (x == (x = 4)) {
            System.out.println(true + " " + x);
        } else {
            System.out.println(false + " " + x);
        }

        System.out.println((x==(x=5)));

        //false4

//        for (int i = 0; i < 1000000; i++) {
//            System.out.print((x==(x=i)));
//            System.out.println(x);
//        }

    }

    @org.junit.Test
    public void PermutationTest() {
        Permutation.go();
    }

    @org.junit.Test
    public void equal() {
        MyTools.printCurrentMethod(true);
        String s = "abc";
        CharSequence charSequence = s;
        System.out.println("s = " + s);
        System.out.println("charSequence = " + charSequence);
        System.out.println("(charSequence==s) = " + (charSequence == s));

    }

    @org.junit.Test
    public void MyDualPivotQuicksortTest() {
        MyDualPivotQuicksort.go();
    }
}
