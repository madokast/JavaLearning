package zrx.com.others;

import zrx.com.MultiThread.MyTools;

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
    public void PermutationTest(){
        Permutation.go();
    }

    @org.junit.Test
    public void equal(){
        MyTools.printCurrentMethod(true);
        String s = "abc";
        CharSequence charSequence = s;
        System.out.println("s = " + s);
        System.out.println("charSequence = " + charSequence);
        System.out.println("(charSequence==s) = " + (charSequence==s));

    }

    @org.junit.Test
    public void MyDualPivotQuicksortTest(){
        MyDualPivotQuicksort.go();
    }
}
