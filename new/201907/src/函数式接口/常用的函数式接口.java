package 函数式接口;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * java util function 下有很多函数式接口
 *
 * Supplier 接口
 */

public class 常用的函数式接口 {
    //public interface Supplier<T> {
    //T get();
    //无参数，获得一个 T
    //Stream.generate()就是传入一个这个东西  Supplier<? extends T> s
    Supplier supplier;

    //public interface Consumer<T> {
    //void accept(T t);
    //用于消费数据
    Consumer consumer;

    //判断接口
    //返回boolean
    //boolean test(T t);
    Predicate predicate;
    // TODO  422

    public static void main(String[] args) {
        supplierTest();
        consumerTest();
        System.out.println("-------------");
        consumerTest2();
    }

    private static void consumerTest2() {
        //andThen
//        default Consumer<T> andThen(Consumer<? super T> after) {
//            Objects.requireNonNull(after);
//            return (T t) -> { accept(t); after.accept(t); };
//        }
        consumerTestDo("123",System.out::println,s-> System.out.println(s+s));
    }

    private static void consumerTestDo(String name,Consumer<String> c,Consumer<String> c2){
        c.andThen(c2).accept(name);
    }

    private static void consumerTest() {
        consumerTestDo("abc",(s)-> System.out.println(s+s));
        consumerTestDo("123",System.out::println);
        consumerTestDo("abcdef",(s)->
            System.out.println(new StringBuffer(s).reverse()));
    }

    private static void consumerTestDo(String name,Consumer<String> c){
        c.accept(name);
    }

    private static void supplierTest() {
        System.out.println(new Supplier<Date>() {
            @Override
            public Date get(){return new Date();}
        }.get());
    }
}
