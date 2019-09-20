package learn;

import com.fasterxml.jackson.databind.ObjectMapper;

public class 三元运算符 {
    public static void main(String[] args) {
        System.out.println(true?65536:'a');
        System.out.println(true?65535:'a');

        fun(65536);
        fun(65535);

        System.out.println(false?10.9:9);


        char ch = true?65535:'a';


        int a = 5;
        String b = "a";

//        char ch2 = true?65536:'a';

        CharSequence charSequence = true?new StringBuilder():"abc";
//        String a = true?new StringBuilder():"abc";
        Object o = true?a:b;
    }

    private static void fun(int i) {
        System.out.println(true?i:'a');
    }
}
