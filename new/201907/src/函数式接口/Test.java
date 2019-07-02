package 函数式接口;

import java.util.Objects;

/**
 * 411
 * 有且只有一个抽象方法的接口
 * 语法糖 foreach 匿名内部类
 *
 * lambda 和 匿名内部类 的区别
 *  没有 class 文件 - 不用加载 所以效率高一点!
 */
public class Test {
    /**
     * 作为方法的参数使用函数式接口
     */
    public void doSomething(MyFunctionalInterface i){
        Objects.requireNonNull(i);
        i.doSomething();
    }

    /**
     * 作为返回值
     */
    public MyFunctionalInterface forDoSomething(){
        return ()-> System.out.println("321");
    }

    public static void main(String[] args) {
        new Test().doSomething(()-> System.out.println("123"));
        new Test().forDoSomething().doSomething();
    }
}
