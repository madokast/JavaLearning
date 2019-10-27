package com.zrx.test;

public class SmallTest {
    public void test() {
        int i = 8;
        while ((i -= 3) > 0)
            ;
        System.out.println("i = "+i);
    }

    public static void main(String[] args) {
        final SmallTest smallTest = new SmallTest();
        for (int i = 0; i < 50_000; i++) {
            smallTest.test();
        }
    }
}
