package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyTimer;

/**
 * Description
 * 学习中断
 * <p>
 * Data
 * 2019/11/20 16:04
 *
 * @author zrx
 * @version 1.0
 */

public class InterruptExceptionTest {
    public static void test(){
        final InterruptExceptionTest interruptException = new InterruptExceptionTest();

        MyTimer.runtime();
        interruptException.noInSleep();
        MyTimer.runtime();

        MyTimer.runtime();
        interruptException.hasInSleep();
        MyTimer.runtime();

        MyTimer.runtime();
        interruptException.checkSelf();
        MyTimer.runtime();
    }

    private void noInSleep(){
        MyTools.printCurrentMethod(true);

        Thread thread = new Thread(()->{
            try {
                for (int i = 0; i < 100000; i++) {
                    MyTools.hardWork(1);
                }
                Thread.sleep(10000);
            }catch (InterruptedException e){
                System.out.println("我收到了InterruptedException");
            }
        });

        thread.setDaemon(true);
        thread.start();

        MyTools.sleepSelf(50);

        thread.interrupt();

        MyTools.sleepSelf(50);
        System.err.println("测试结束");
    }

    private void hasInSleep(){
        MyTools.printCurrentMethod(true);

        Thread thread = new Thread(()->{
            try {
                for (int i = 0; i < 100000; i++) {
                    Thread.sleep(1);
                    MyTools.hardWork(1);
                }
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"我收到了InterruptedException");
            }
        });

        thread.setDaemon(true);
        thread.start();

        MyTools.sleepSelf(50);

        thread.interrupt();

        MyTools.sleepSelf(50);
        System.err.println("测试结束");
    }

    private void checkSelf(){
        MyTools.printCurrentMethod(true);

        Thread thread = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"我头上有中断标记，退出");
                    break;
                }
                MyTools.hardWork(1);
            }
        });

        thread.setDaemon(true);
        thread.start();

        MyTools.sleepSelf(50);

        thread.interrupt();

        MyTools.sleepSelf(50);
        System.err.println("测试结束");
    }
}
