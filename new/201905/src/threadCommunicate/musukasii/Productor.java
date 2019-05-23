package threadCommunicate.musukasii;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Productor implements Runnable {
    private final Lock lock = Room.getLOCK();
    private static final Lock productorLock = new ReentrantLock();
    private int num = 0;
    @Override
    public void run() {
        while (true) {
            synchronized(Room.class){
                if(!Room.isFull()){
                    num++;
                    System.out.println(Thread.currentThread().getName()+"生产"+num);
                    Room.producr(Thread.currentThread().getName()+"的"+num);
                }
                else{
                    Room.class.notify();
                    try {
                        Room.class.wait();
                    }catch (Exception e){e.printStackTrace();}
                }
            }
        }
    }

    public void oldrun(){
        while (true) {
            productorLock.lock();
            lock.lock();
            try{

                Thread.currentThread().sleep(100);


                if(!Room.isFull()){
                    num++;
                    System.out.println(Thread.currentThread().getName()+"生产"+num);
                    Room.producr(Thread.currentThread().getName()+"的"+num);
                }
                else{
                    Shopper.getSjopperLock().notify();
                }

            }catch (Exception e){e.printStackTrace();}
            finally {
                lock.unlock();
                productorLock.lock();
                continue;
            }
        }
    }

    public static Lock getProductorLock(){
        return productorLock;
    }
}
