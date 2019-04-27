package IDEAJAVALEARN.stringTest;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  字符串联系
 *  字符串特俗
 *  1。不可变
 *  2。因为不可变，可以共享使用
 *  3。字符串效果是相当于char[]，但是底层是byte[]数组
 *
 *  字符串创建方法
 *  String()
 *  String(char[] array)
 *  String(byte[] array)
 */
public class Test {
    public static void main(String[] args){
        System.out.println("hello");

        String cons1 = new String(new char[]{'A','B','C','D'});
        System.out.println("cons1 = " + cons1);//cons1 = ABCD

        String cons2 = new String(new byte[]{97,98,99});
        System.out.println("cons2 = " + cons2);//cons2 = abc
        
        String cons = new String("123");//= "123"  
        
        String a = "qqq";
        String b = "qqq";
        String c = new String(new char[]{'q','q','q'});
        System.out.println(a==b);
        System.out.println(a==c);
        //字符串常量池
        //放在堆中
        //new出来的字符串和常量池没关系

        //常用api
        //相等
        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("a.equals(c) = " + a.equals(c));
        String a1 = "abc";
        String a2 = "ABC";
        System.out.println("a2.equalsIgnoreCase(a1) = " + a2.equalsIgnoreCase(a1));

        //获取方法
        System.out.println("a2.length() = " + a2.length());
        System.out.println("\"123\".concat(\"abc\") = " + "123".concat("abc"));
        System.out.println("\"123\".charAt(1) = " + "123".charAt(1));
        System.out.println("\"12345\".indexOf(\"23\") = " + "12345".indexOf("23"));

        System.out.println("\"1234556\".substring(2,5) = " + "1234556".substring(2,5));

        char[] chars = "123456".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+ " ");
        }
        System.out.println();

        System.out.println("\"1212121212\".replace('2','3') = " + "1212121212".replace('2', '3'));

        String[] strings = "123 456 789".split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        String[] strings1 = "abc.def.g".split("\\.");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }


    }
}
