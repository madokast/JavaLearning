package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description
 * 生成者和消费者
 * <p>
 * Data
 * 2019/12/3 20:43
 *
 * @author zrx
 * @version 1.0
 */

public class ProducerConsumer {
    public static void go() {
        new ProducerConsumer().test();
    }

    public void test() {
        MyTools.printCurrentMethod(true);
        final Queue<String> queue = new LinkedBlockingQueue<>(5);


        new Producer(queue, "生产者1").start();
        new Producer(queue, "           生产者2").start();
        new Consumer(queue, "                        消费者1").start();


        MyTools.sleepSelf(1000);
    }

    private class Consumer extends Thread {
        private final Queue<String> queue;
        private String name;
        private static final int MAX_SIZE = 5;

        public Consumer(Queue<String> queue, String name) {
            this.queue = queue;
            this.name = name;
            this.setName(name);
            this.setDaemon(true);
        }

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        final String s = queue.poll();
                        MyTools.printMsgWithThreadAndTime("拿出产品:" + s);
                        queue.notify();
                    } else {
                        MyTools.printMsgWithThreadAndTime("发现队列是空的");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private class Producer extends Thread {
        private final Queue<String> queue;
        private String name;
        private Random random = new Random();
        private static final int MAX_SIZE = 5;


        public Producer(Queue<String> queue, String name) {
            this.queue = queue;
            this.name = name;
            this.setName(name);
            this.setDaemon(true);
        }

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            int n = -1;
            while (true) {
                if (n == -1) {
                    n = random.nextInt(100);
                    MyTools.sleepSelf(100);
                    MyTools.printMsgWithThreadAndTime("生成产品 " + n);
                }

                synchronized (queue) {
                    if (queue.size() < MAX_SIZE) {
                        MyTools.printMsgWithThreadAndTime("发现队列没有满，加入" + n);
                        queue.offer(name + "-" + n);
                        n = -1;
                        queue.notify();
                    } else {
                        MyTools.printMsgWithThreadAndTime("队列已满，不放入");

                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


//                if (queue.size() < MAX_SIZE) {
//                    synchronized (queue) {
//                        if (queue.size() < MAX_SIZE) {
//                            MyTools.printMsgWithThreadAndTime("发现队列没有满，加入" + n);
//                            queue.offer(name + "-" + n);
//                            n = -1;
//                        } else {
//                            MyTools.printMsgWithThreadAndTime("神奇，居然双重检查锁起效了，队列已满，不放入");
//                        }
//                    }
//                } else {
//                    MyTools.printMsgWithThreadAndTime("队列已满，不放入");
//                }
            }
        }
    }
}
