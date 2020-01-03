package zrx.com.MultiThread.Basic.test;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * test
 * <p>
 * Data
 * 2019/12/25 17:13
 *
 * @author zrx
 * @version 1.0
 */

public class WaitTest {

    private Object lock = new Object();

    public void test() {
        MyTools.printCurrentMethod(true,"WaitTest Interrupt测试");
        MyTools.printMsgWithThreadAndTime("InnerInterrupt测试");
        final Thread innerInterrupt = MyTools.runItInThread(this::waitInnerInterrupted, "InnerInterrupt", true);
        MyTools.sleepSelf(200);
        innerInterrupt.interrupt();
        MyTools.joinAll(
                innerInterrupt,
                MyTools.runItInThread(this::holdLock,"holdLock",true)
        );
        MyTools.printMsgWithThreadAndTime("测试结束");



        MyTools.printMsgWithThreadAndTime("OutterInterrupt");
        final Thread outterInterrupt = MyTools.runItInThread(this::waitOutterInterrupted, "OutterInterrupt", true);
        MyTools.sleepSelf(200);
        outterInterrupt.interrupt();
        MyTools.joinAll(
                outterInterrupt,
                MyTools.runItInThread(this::holdLock,"holdLock2",true)
        );
        MyTools.printMsgWithThreadAndTime("测试结束");
    }

    private void waitInnerInterrupted() {
        synchronized (lock) {
            MyTools.printMsgWithThreadAndTime("进入同步代码块");
            try {
                MyTools.printMsgWithThreadAndTime("wait释放锁");
                lock.wait();
            } catch (InterruptedException e) {
                MyTools.printMsgWithThreadAndTime("同步代码块不跳出的中断处理");
            }
        }
    }

//    {
//        synchronized (lock) {
//            try { lock.wait(); }
//            catch (InterruptedException e) {
//                MyTools.printMsgWithThreadAndTime("同步代码块不跳出的中断处理");
//            }
//        }
//    }

    private void waitOutterInterrupted() {
        try {
            synchronized (lock) {
                MyTools.printMsgWithThreadAndTime("进入同步代码块");
                MyTools.printMsgWithThreadAndTime("wait释放锁");
                lock.wait();
            }
        }catch (InterruptedException e){
            MyTools.printMsgWithThreadAndTime("跳出同步代码块中断处理");
        }
    }

//    {
//        try {
//            synchronized (lock) { lock.wait(); }
//        }catch (InterruptedException e){
//            MyTools.printMsgWithThreadAndTime("跳出同步代码块中断处理");
//        }
//    }

    private void holdLock() {
        synchronized (lock) {
            MyTools.printMsgWithThreadAndTime("进入同步代码块，并占用此锁2s");
            MyTools.sleepSelf(2 * 1000);
            MyTools.printMsgWithThreadAndTime("2s过去释放锁");
        }
    }
}
