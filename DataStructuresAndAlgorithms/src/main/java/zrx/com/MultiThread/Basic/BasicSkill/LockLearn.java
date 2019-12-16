package zrx.com.MultiThread.Basic.BasicSkill;

import sun.misc.Unsafe;
import zrx.com.MultiThread.MyTools;

import java.lang.reflect.Field;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description
 * Lock
 * <p>
 * Data
 * 2019/12/10 22:21
 *
 * @author zrx
 * @version 1.0
 */

public class LockLearn {
    public static void go(){
        new LockLearn().test01();
        new LockLearn().unSafe();
        new LockLearn().inter();
        new LockLearn().test02();
        new LockLearn().test03();
    }

    private void test03(){
        MyTools.printCurrentMethod(true,"顺序作业");

        OrderService service = new OrderService();

        MyTools.runItInThread(()->service.a(8,9),true);
        MyTools.runItInThread(()->service.a(7,8),true);
        MyTools.runItInThread(()->service.a(6,7),true);
        MyTools.runItInThread(()->service.a(5,6),true);
        MyTools.runItInThread(()->service.a(4,5),true);
        MyTools.runItInThread(()->service.a(3,4),true);
        MyTools.runItInThread(()->service.a(2,3),true);
        MyTools.runItInThread(()->service.a(1,2),true);

        MyTools.sleepSelf(100);

    }

    private class OrderService{
        Lock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        volatile int info = 1;

        void a(int i,int j){
            lock.lock();
            try{
                while(info!=i){
                    condition.await();
                }
                MyTools.printMsgWithThreadAndTime(""+i+i+i);
                info=j;
                condition.signalAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

            CompletionStage completionStage;
            CompletionStage completableFuture;
//            CompletableFuture.supplyAsync()
//            completionStage.whenComplete()

//            SecurityManager securityManager = System.getSecurityManager();

            AtomicInteger atomicInteger = new AtomicInteger(1);
//            atomicInteger.compareAndSet()


            Unsafe unsafe;
//            unsafe.loadFence();
//            unsafe.storeFence();

//            unsafe.objectFieldOffset(field)



        }
    }

    private void test02(){
        MyTools.printCurrentMethod(true,"一些函数");
        ReentrantLock lock = new ReentrantLock();

        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());
        lock.lock();
        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());
        lock.lock();
        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());
        lock.unlock();
        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());
        lock.unlock();
        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());
//        MyTools.printMsgWithThreadAndTime(""+lock.getHoldCount());

    }

    private void test00(){
        MyTools.printCurrentMethod(true,"源碼閲讀");
        Lock lock = new ReentrantLock();
        LockSupport lockSupport;
    }

    private void inter(){
        MyTools.printCurrentMethod(true);
        final ServiceInter serviceInter = new ServiceInter();
//        final Thread thread = MyTools.runItInThread(serviceInter::a, true);
//        final Thread thread1 = MyTools.runItInThread(serviceInter::b, true);
//
////        MyTools.joinAll(50,thread,thread1);
//        MyTools.sleepSelf(10);
//        thread.interrupt();
//        thread1.interrupt();

        System.out.println("运行示例");
        System.out.println("[Thread-4]: ★★★[1571]\n" +
                "[Thread-3]: ☆☆☆[1572]\n" +
                "[Thread-4]: ★★★[1572]\n" +
                "[Thread-3]: ☆☆☆[1573]\n" +
                "[Thread-4]: ★★★[1573]\n" +
                "[Thread-3]: ☆☆☆[1574]\n" +
                "[Thread-4]: ★★★[1574]");
    }

    class ServiceInter{
        Lock lock = new ReentrantLock(true);
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        boolean kuro = false;

        void a(){
            while (true){
                lock.lock();
                try {
                    while (kuro){
                        conditionA.await();
                    }
                    kuro = true;
                    MyTools.printMsgWithThreadAndTime("☆☆☆");
                    conditionB.signal();
                }catch (InterruptedException e){
//                    e.printStackTrace();
                    break;
                }finally {
                    lock.unlock();
                }
            }
        }

        void b(){
            while (true){
                lock.lock();
                try {
                    while (!kuro){
                        conditionB.await();
                    }
                    kuro = false;
                    MyTools.printMsgWithThreadAndTime("★★★");
                    conditionA.signal();
                }catch (InterruptedException e){
//                    e.printStackTrace();
                    break;
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    private void unSafe(){
        MyTools.printCurrentMethod(true);


        Unsafe unsafe = null;
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        MyTools.printMsgWithThreadAndTime("准备park");
        unsafe.park(true,300);
        MyTools.printMsgWithThreadAndTime("park结束");



    }

    private void test01(){
        MyTools.printCurrentMethod(true,"Lock入门");
        final Service01 service01 = new Service01();
        final Thread thread1 = MyTools.runItInThread(service01::print, false);
        final Thread thread2 = MyTools.runItInThread(service01::print, false);
        final Thread thread3 = MyTools.runItInThread(service01::print, false);

        MyTools.joinAll(thread1,thread2,thread3);
    }


    class Service01{
        private Lock lock = new ReentrantLock();
        void print(){
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    MyTools.printMsgWithThreadAndTime(String.valueOf(i));
                    MyTools.sleepSelf(100);
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
