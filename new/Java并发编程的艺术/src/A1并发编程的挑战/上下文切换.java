package A1并发编程的挑战;

import Tools.Timer;

/**
 * 并发编程是为了速度更快，而不是线程数目更多
 * 减少上下文切换是提高并发编程效率的办法
 *
 * 具体来说
 *      无锁并发编程
 *      CAS算法？
 *          CAS:Compare and Swap,是比较并交换的意思。
 *      使用最少线程
 *      携程
 */

public class 上下文切换 {
    private static final long count = 10000 * 100 * 100 * 100 + 1;

    public static void main(String[] args) throws InterruptedException {
        serial();
        concurrency();
    }

    private static void concurrency() throws InterruptedException {
        Timer.invoke();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        Timer.invoke();
    }

    private static void serial() {
        Timer.invoke();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        Timer.invoke();
    }
}
