package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 学习join
 * <p>
 * Data
 * 2019/12/7 14:59
 *
 * @author zrx
 * @version 1.0
 */

public class JoinLearn {
    public static void go(){

    }

    private void test01(){
        MyTools.printCurrentMethod(true,"join方法释放锁？");

        final Thread thread = MyTools.runItInThread(
                () -> System.out.println("join方法释放锁？"), false);

        try {
            thread.join();
//            thread.start();
            System.out.println("join 方法有public final synchronized void join(final long millis)");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
