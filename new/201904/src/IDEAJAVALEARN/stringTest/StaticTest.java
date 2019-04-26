package IDEAJAVALEARN.stringTest;

import java.util.Arrays;

public class StaticTest {
    static {
        a=20;
    }
    {
        a=123;
    }
    public static void main(String[] args) {
        System.out.println("a = " + a);
        new StaticTest();
        System.out.println("a = " + a);

//        Arrays.parallelSort();
    }
    public static int a=10;
}
