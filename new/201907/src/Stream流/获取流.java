package Stream流;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * 怎么获得列？
 * collection集合的stream()方法
 * stream of 方法
 */

public class 获取流 {
    public static void main(String[] args) {
        Stream.of(new String[]{"1","a"}).forEach(System.out::print);
//        test();
    }

    private static void test(){
        Collection collection = null;
        Stream stream = collection.stream();
        Stream<Object> of = Stream.of();
    }
}
