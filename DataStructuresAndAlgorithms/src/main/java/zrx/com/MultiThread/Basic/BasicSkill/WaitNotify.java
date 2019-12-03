package zrx.com.MultiThread.Basic.BasicSkill;

import sun.misc.Unsafe;
import zrx.com.MultiThread.MyTools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description
 * 学习wait notify
 * <p>
 * Data
 * 2019/12/3 16:28
 *
 * @author zrx
 * @version 1.0
 */

public class WaitNotify {
    public static void go() {
        new WaitNotify().test01();
        new WaitNotify().test02();
        new WaitNotify().test04();
        new WaitNotify().test05();
    }

    private void test05(){
        MyTools.printCurrentMethod(true,"notify唤醒顺序");

        final Object lock = new Object();

        FutureTask<Void> f = new FutureTask<Void>(()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入同步方法，wait");
                lock.wait();
                MyTools.printMsgWithThreadAndTime("被唤醒了");
            }
            return null;
        });

        FutureTask<Void> f1 = new FutureTask<Void>(()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入同步方法，wait");
                lock.wait();
                MyTools.printMsgWithThreadAndTime("被唤醒了");
            }
            return null;
        });


        FutureTask<Void> f2 = new FutureTask<Void>(()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入同步方法，notify");
                lock.notify();
                MyTools.printMsgWithThreadAndTime("被唤醒了");
            }
            return null;
        });

        FutureTask<Void> f3 = new FutureTask<Void>(()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入同步方法，notifyAll");
                lock.notifyAll();
                MyTools.printMsgWithThreadAndTime("被唤醒了");
            }
            return null;
        });

//        MyTools.sleepSelf(2000);

        final Thread t = MyTools.runItInThread(f, true);
        MyTools.sleepSelf(1000);
        final Thread t1 = MyTools.runItInThread(f1, true);
        MyTools.sleepSelf(1000);
        final Thread t2 = MyTools.runItInThread(f3, true);
        MyTools.sleepSelf(1000);

        MyTools.joinAll(t,t1,t2);

//        System.err.println("");

    }

    private void test04(){
        MyTools.printCurrentMethod(true,"notify不会立马释放锁");

        final Object lock = new Object();

        Callable<Void> r = ()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入锁");
                MyTools.printMsgWithThreadAndTime("wait");
                lock.wait();
                MyTools.printMsgWithThreadAndTime("被唤醒了");
            }
            return null;
        };

        Callable<Void> r2 = ()->{
            MyTools.printMsgWithThreadAndTime("开始执行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入锁");
                MyTools.printMsgWithThreadAndTime("250m后调用notify");
                lock.notify();
                MyTools.printMsgWithThreadAndTime("250m后出同步块");
                MyTools.sleepSelf(250);
            }
            return null;
        };

        final Thread thread = MyTools.runItInThread(new FutureTask<Void>(r), true);

        MyTools.sleepSelf(50);

        final Thread thread1 = MyTools.runItInThread(new FutureTask<Void>(r2), true);

        try {
            thread.join();
            thread1.join();
        }catch (InterruptedException e){e.printStackTrace();}

    }

    private void test03(){
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Callable r = ()->{
            MyTools.printMsgWithThreadAndTime("开始运行");
            synchronized (lock1){
                MyTools.printMsgWithThreadAndTime("进入了第一把锁");
                synchronized (lock2){
                    MyTools.printMsgWithThreadAndTime("进入了第二把锁，开始wait");

                }
            }


            return null;
        };
    }

    private void test02(){
        MyTools.printCurrentMethod(true,"wait会立马放弃锁");
        final Object lock = new Object();
        Runnable r = ()->{
            MyTools.printMsgWithThreadAndTime("开始运行");
            synchronized (lock){
                MyTools.printMsgWithThreadAndTime("进入同步代码块");
                try {
                    MyTools.sleepSelf(200);
                    MyTools.printMsgWithThreadAndTime("200ms后调用wait");
                    MyTools.sleepSelf(200);
                    lock.wait();
                    MyTools.printMsgWithThreadAndTime("不会执行");
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };

        MyTools.runItInThread(r,true);
        MyTools.runItInThread(r,true);
        MyTools.sleepSelf(200);
        MyTools.runItInThread(r,true);

//        MyTools.sleepSelf(1000);


    }

    private void test01() {
        MyTools.printCurrentMethod(true);
        System.err.println("执行wait没有锁，抛出IllegalMonitorStateException异常");
        System.err.println("执行notify没有锁，抛出IllegalMonitorStateException异常");

        final Object obj = new Object();
//        try
        {
//            obj.wait();
            //java.lang.IllegalMonitorStateException
            //	at java.base/java.lang.Object.wait(Native Method)
            //	at java.base/java.lang.Object.wait(Object.java:326)
            //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.test01(WaitNotify.java:26)
            //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.go(WaitNotify.java:18)
            //	at zrx.com.MultiThread.Basic.Test.TestWaitNotify(Test.java:22)

//            obj.notify();
            //java.lang.IllegalMonitorStateException
            //	at java.base/java.lang.Object.notify(Native Method)
            //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.test01(WaitNotify.java:35)
            //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.go(WaitNotify.java:18)
            //	at zrx.com.MultiThread.Basic.Test.TestWaitNotify(Test.java:22)

        }
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }

        System.err.println("lock上锁后，对lock.wait，一样有IllegalMonitorStateException");

        if(Math.sin(0.1)>100){
            Runnable r = () -> {
                MyTools.printMsgWithThreadAndTime("线程开始运行");
                Lock lock = new ReentrantLock();
                lock.lock();
                MyTools.printMsgWithThreadAndTime("上锁成功");
                try {
                    MyTools.printMsgWithThreadAndTime("调用lock.wait();");
                    lock.wait();
                    //Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
                    //	at java.base/java.lang.Object.wait(Native Method)
                    //	at java.base/java.lang.Object.wait(Object.java:326)
                    //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.lambda$test01$0(WaitNotify.java:59)
                    //	at java.base/java.lang.Thread.run(Thread.java:835)
                    //这里应该可以上锁
                    MyTools.printMsgWithThreadAndTime("不应该被打印出");
                } catch (InterruptedException e) {
                    MyTools.printMsgWithThreadAndTime("我被打断了");
                    //不会发出来
                    e.printStackTrace();
                } finally {
                    MyTools.printMsgWithThreadAndTime("解锁。不知道会不会被打印出");
                    lock.unlock();
                }
            };

            final Thread thread = MyTools.runItInThread(r, true);

            MyTools.printMsgWithThreadAndTime("main:休息5秒");

            MyTools.sleepSelf(5000);

            MyTools.printMsgWithThreadAndTime("main:打断");

            thread.interrupt();

            MyTools.printMsgWithThreadAndTime("main:休息5秒");

            MyTools.sleepSelf(5000);

            //Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
            //	at java.base/java.lang.Object.wait(Native Method)
            //	at java.base/java.lang.Object.wait(Object.java:326)
            //	at zrx.com.MultiThread.Basic.BasicSkill.WaitNotify.lambda$test01$0(WaitNotify.java:61)
            //	at java.base/java.lang.Thread.run(Thread.java:835)
            //[Thread-0]: 线程开始运行[24]
            //[main]: main:休息5秒[1]
            //[Thread-0]: 上锁成功[47]
            //[Thread-0]: 调用lock.wait();[47]
            //[Thread-0]: 解锁。不知道会不会被打印出[47]
            //[main]: main:打断[5047]
            //[main]: main:休息5秒[5047]
        }

        System.err.println("Mark Word");
        if(true){

            final List<String> list = new ArrayList<>();
            list.add("123");

            MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
            MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());

            Runnable r = ()->{
                MyTools.printMsgWithThreadAndTime("进入同步代码块前");
                MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());
                synchronized (list){
                    MyTools.printMsgWithThreadAndTime("进入同步代码块后");
                    MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                    MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());

                    try {
                        MyTools.printMsgWithThreadAndTime("list.wait();");
                        list.wait();
                    }catch (Exception e){e.printStackTrace();}

                    MyTools.printMsgWithThreadAndTime("从wait出来");
                    MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                    MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());
                }
            };

            Runnable r2 = ()->{
                MyTools.printMsgWithThreadAndTime("进入同步代码块前");
                MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());
                synchronized (list){
                    MyTools.printMsgWithThreadAndTime("进入同步代码块后");
                    MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                    MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());

                    try {
                        MyTools.printMsgWithThreadAndTime("list.notify();");
                        list.notify();
                    }catch (Exception e){e.printStackTrace();}

                    MyTools.printMsgWithThreadAndTime("从notify出来");
                    MyTools.printMsgWithThreadAndTime("identityHashCode=" + System.identityHashCode(list));
                    MyTools.printMsgWithThreadAndTime("list.hashCode()="+list.hashCode());
                }
            };

            MyTools.runItInThread(r,true);
            MyTools.sleepSelf(200);
            MyTools.runItInThread(r2,true);
            MyTools.sleepSelf(200);
        }

        //[main]: identityHashCode=1513712028[12]
        //[main]: list.hashCode()=48721[44]
        //[Thread-0]: 进入同步代码块前[51]
        //[Thread-0]: identityHashCode=1513712028[51]
        //[Thread-0]: list.hashCode()=48721[52]
        //[Thread-0]: 进入同步代码块后[52]
        //[Thread-0]: identityHashCode=1513712028[53]
        //[Thread-0]: list.hashCode()=48721[53]
        //[Thread-0]: list.wait();[54]
        //[Thread-1]: 进入同步代码块前[253]
        //[Thread-1]: identityHashCode=1513712028[253]
        //[Thread-1]: list.hashCode()=48721[253]
        //[Thread-1]: 进入同步代码块后[254]
        //[Thread-1]: identityHashCode=1513712028[254]
        //[Thread-1]: list.hashCode()=48721[255]
        //[Thread-1]: list.notify();[257]
        //[Thread-1]: 从notify出来[257]
        //[Thread-1]: identityHashCode=1513712028[258]
        //[Thread-1]: list.hashCode()=48721[259]
        //[Thread-0]: 从wait出来[259]
        //[Thread-0]: identityHashCode=1513712028[259]
        //[Thread-0]: list.hashCode()=48721[260]
    }
}
