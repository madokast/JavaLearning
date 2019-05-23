package synchronizedLearn.sareLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock接口显示的上锁和释放锁
 *
 * lock()
 * unlock()
 *
 * 实现类：ReentrantLock
 *
 *  ！！！ReentrantLock必须在方法外创建，而不是在需要同步的地方创建
 */

public class Window implements Runnable {
    private int ticket = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run(){
        while (true){
            lock.lock();


            if(ticket>0){
                try {
                    Thread.currentThread().sleep(10);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"卖出"+ticket);
                ticket--;
                lock.unlock();
        }
            else {
                System.out.println(Thread.currentThread().getName()+"售罄!");
                lock.unlock();
                break;
            }
        }
    }
}
