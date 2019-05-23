package threadCommunicate.musukasii;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shopper implements Runnable {
    private final Lock lock = Room.getLOCK();
    private static final Lock shopperLock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            synchronized (Room.class){
                if(!Room.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"消费"+Room.shop());
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
            shopperLock.lock();
            lock.lock();
            try{

                Thread.currentThread().sleep(100);

                if(!Room.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"消费"+Room.shop());
                }
                else{
                    Productor.getProductorLock().notify();
                }
            }catch (Exception e){e.printStackTrace();}
            finally {
                lock.unlock();
                shopperLock.unlock();
                break;
            }

        }
    }

    public static Lock getSjopperLock(){
        return shopperLock;
    }
}
