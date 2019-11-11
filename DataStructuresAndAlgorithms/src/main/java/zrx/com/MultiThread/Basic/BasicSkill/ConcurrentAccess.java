package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 并发访问问题
 * synchronized 关键字
 * <p>
 * Data
 * 2019/11/9 21:52
 *
 * @author zrx
 * @version 1.0
 */

public class ConcurrentAccess {
    static final int PERIOD = 500 ;
    public static void test(){
        final ConcurrentAccess concurrentAccess = new ConcurrentAccess();
        concurrentAccess.ConcurrentAccessSynchronizedTest01();
        System.out.println("------------------");
        concurrentAccess.sonTest();
    }

    private void ConcurrentAccessSynchronizedTest01(){
        System.err.println("ConcurrentAccessSynchronizedTest01");
        final ConcurrentAccessSynchronized concurrentAccessSynchronized = new ConcurrentAccessSynchronized();

        new Thread(concurrentAccessSynchronized::methodA).start();
        MyTools.hardWork(1);
        new Thread(concurrentAccessSynchronized::methodB).start();

        MyTools.sleepSelf(PERIOD);
    }

    private void sonTest(){
        System.err.println("sonTest");
        final Son son = new Son();
        new Thread(son::methodB).start();
        new Thread(son::methodB).start();
        new Thread(son::methodB).start();

        MyTools.hardWork(2);
    }
}

class ConcurrentAccessSynchronized{
    synchronized void methodA(){
        System.out.println("methodA");
        methodB();
        MyTools.sleepSelf(ConcurrentAccess.PERIOD);
    }
    synchronized void methodB(){
        System.out.println("methodB");
        MyTools.sleepSelf(ConcurrentAccess.PERIOD);
    }
}

class Son extends ConcurrentAccessSynchronized{
    @Override
    void methodB() {
        System.out.println("子类methodB没有synchronized");
    }
}
