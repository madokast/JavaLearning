package 函数式编程;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] strings = {"aa","b","aaa","ccccc",""};
        Arrays.sort(strings,getMyComparator());
        Arrays.stream(strings).forEach(System.out::println);
    }

    public static Comparator<String> getMyComparator(){
//      return (s1,s2)->s1.length()-s2.length();
        return Comparator.comparing(String::length);
    }
}
