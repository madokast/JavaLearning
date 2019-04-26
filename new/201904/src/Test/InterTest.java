package Test;

/**
 * 接口复习
 *
 * @version 2019年4月26日
 */

public interface InterTest {
    /**
     * 接口中的变量
     * 一定是public static final
     * 可以不用写
     */
    public static final int a = 10;

    /**
     * 接口中的一般方法
     * 一定是public abstract
     * 可以不用写
     * @param a op1
     * @param b op2
     * @return operation on a and b
     */
    public abstract int operation(int a , int b);

    /**
     * Java8以后，接口中可以定义default修饰的方法
     *“接口种被default标记的方法为普通方法”
     * 实现类会继承接口中的default方法
     */
    public default void defaultMathod(){
        System.out.println("defaultMathod in interface");
    }
}
