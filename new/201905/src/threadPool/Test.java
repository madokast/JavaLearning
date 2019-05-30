package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * 原因：
 *      若每次自己创建线程，这样创建线程和销毁线程浪费资源和时间
 *
 * 线程池：
 *      复用线程。
 *      就是一个容器
 *      即，使用集合 HashSet<Thread>
 *      remove 得到一个线程，使用它
 *      使用完之后 add 还回去
 *
 * JDK 1.5之后内置了线程池，可以直接使用
 *
 * java.util.concurrent.Executors 生产线程池的工厂类
 *      newFixedThreadPool(int num) 创建一个固定大小的线程池
 *
 * java.util.concurrent.ExecutorService 这个才是线程池（接口）
 *      submit() q提交一个Runnable任务用于执行，并返回表示该任务的future
 *      shutdown() 销毁线程池
 */

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+123));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+124));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+125));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+126));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+127));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+128));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+129));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+120));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()+" "+121));

        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+" "+223));
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+" "+323));
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+" "+423));
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+" "+523));
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+" "+623));

        executorService.shutdown();
    }
}
