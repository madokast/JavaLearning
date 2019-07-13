package Stream流;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 433
 * foreach()
 * 434
 * filter()
 * 435
 * stream 流特点
 *  属于管道流，只能被消费一次。数据在stream流一个接一个的流转
 * 436
 * map()
 * 437
 * count()
 * 438
 * limit()
 * 439
 * skip()
 * 440
 * concat()
 */
public class 常用方法 {
    public static void main(String[] args) {
        final int[] ints = {1, -1, 2, -2, 3, -3, 0};
        final int[] ints2 = {10, -10, 20, -20, 30, -30, 00};
        final IntStream stream0 = Arrays.stream(ints);
        final IntStream stream2 = Arrays.stream(ints2);
//        stream0.map(e->e*e).forEach(System.out::println);
//        System.out.println("stream0.count() = " + stream0.count());
//        stream0.limit(3).limit(5).forEach(System.out::println);
//        stream0.skip(20).forEach(System.out::println);
        Stream.concat(stream0.mapToObj(e->(Integer)e),stream2.mapToObj(e->(Integer)e)).forEach(System.out::println);

    }

}
