package 函数式接口;

/**
 * 注解 @FunctionalInterface
 */

@FunctionalInterface
public interface MyFunctionalInterface {
    void doSomething();

    default void help(){
        System.out.println("这是个函数式接口");
    }
}
