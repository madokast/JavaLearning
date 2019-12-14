package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 学习
 * <p>
 * Data
 * 2019/12/7 15:38
 *
 * @author zrx
 * @version 1.0
 */

public class ThreadLocalTest {
    public static void go(){
        new ThreadLocalTest().test01();
    }


    private void test01(){
        MyTools.printCurrentMethod(true,"线程局部变量");

        System.out.println("stringThreadLocal.get() = " + stringThreadLocal.get());
        System.out.println("stringThreadLocal2.get() = " + stringThreadLocal2.get());



    }

    private ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(()->"初始值");
    private ThreadLocal<String> stringThreadLocal2  = new ThreadLocal<>();


    class A{
        A(int i){
            System.out.println("i = " + i);
        }
    }

    class B extends A{
        B(){
            super(2);
        }
    }

}
