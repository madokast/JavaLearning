package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 如何停止一个线程
 * interrupt()方法
 * 中断仅仅是在线程对象做一个标记而已，称为中断标志。
 * 仅仅是一个标记，线程可以自己查看是否有这个标记
 *
 * <p>
 * Data
 * 2019/11/9 17:34
 *
 * @author zrx
 * @version 1.0
 */

public class HowToStopAThread {
    private static final int PERIOD = 300 ;
    public static void learn(){
        final HowToStopAThread how = new HowToStopAThread();
        how.interruptMethod();
        System.out.println("-----------------------");
        how.sleepAndInterruptedException();
        System.out.println("-----------------------");
        how.daemonTest();
    }

    private void interruptMethod(){
        System.err.println("interrupt()方法标记线程");
        Thread thread = new Thread(()->{
            try {
                for (int i = 0; i < 10000; i++) {
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("\n发现中断标记，停止运行");
                        throw new InterruptedException();
                    }
                    MyTools.hardWork(1);
                    System.out.print(i);
                }
            }catch (InterruptedException e){
                System.out.println("一个线程有中断信号就会抛出InterruptedException");
                System.out.println("释放资源");
            }
        });

        thread.start();
        MyTools.sleepSelf(PERIOD);
        thread.interrupt();//做上标记

        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void sleepAndInterruptedException(){
        System.err.println("sleepAndInterruptedException好梦被打断");
        Thread thread = new Thread(()->{
            try {
                System.out.println("开始做梦");
                Thread.sleep(10000);
            }catch (InterruptedException e){
                System.out.println("我的美梦配吵醒了");
                System.out.println("释放资源");
            }
        });

        thread.start();
        MyTools.sleepSelf(100);
        thread.interrupt();

        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void daemonTest(){
        System.err.println("daemon 守护线程");
        Thread tA = new Thread(()->{
            System.out.println("我是守护线程tA");
            for (int i = 0; i < 1000; i++) {
                System.out.print("tA");
                MyTools.hardWork(128);
            }
        });

        Thread tB = new Thread(()->{
            System.out.println("我是守护线程tB");
            for (int i = 0; i < 1000; i++) {
                System.out.print("tB");
                MyTools.hardWork(64);
            }
        });

        tA.setDaemon(true);
        tB.setDaemon(true);

        tA.start();
        tB.start();
        MyTools.sleepSelf(PERIOD);
        return;
    }
}
