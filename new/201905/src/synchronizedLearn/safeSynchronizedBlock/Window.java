package synchronizedLearn.safeSynchronizedBlock;

/**
 * 利用同步代码块解决线程安全
 * synchronized{锁对象}(临界代码)
 *
 * 注意：
 *  1.锁对象可以是任意对象？
 *  2.但是必须保证多个线程使用的锁对象是同一个
 *  3.锁对象的作用：把临界区锁住，只让一个对象在同步代码块中执行
 *
 *
 * 原理分析
 *   锁对象 == 同步锁 == 对象锁 == 对象监视器
 *  锁对象一开始存在，当一个线程进入临界区时，首先查看锁是否存在
 *  若存在，就获取锁对象，然后进入临界区
 *  若不存在，就阻塞
 *  送有锁对象的线程执行完临界区后，会归还锁
 *
 *  没有执行完毕，不会释放锁
 */

public class Window implements Runnable {
    private int ticket = 100;

    //创建一个锁对象
    private Object o = new Object();

    @Override
    public void run(){
        while (true){
            synchronized (o){
                if(ticket>0){
                    try {
                        Thread.currentThread().sleep(10);
                    }catch (Exception e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"卖出"+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }
        }
    }
}
