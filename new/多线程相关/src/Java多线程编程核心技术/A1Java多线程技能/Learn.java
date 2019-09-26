package Java多线程编程核心技术.A1Java多线程技能;

import Java并发编程的艺术.Tools.Sleep;

import java.sql.Connection;

public class Learn {
    public static void main(String[] args) {
//        t1();
//        t2();
//        t3();
        t4();
    }

    private static void t4() {
        Runnable runnable = new MyRun();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");

        t1.start();
        t2.start();

        Sleep.sleep(5000);
        System.out.println("---------------");

        Runnable runnable2 = new MyMyRun();
        Thread t12 = new Thread(runnable2, "t12");
        Thread t22 = new Thread(runnable2, "t22");

        t12.start();
        t22.start();
    }

    private static class MyMyRun extends MyRun{
        private int count = 10;

        @Override
        public void run(){
            int c = count;
            c = c-1;
            Sleep.sleep(1000);
            count = c;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

    private static class MyRun implements Runnable {
        private int count = 10;

        @Override
        synchronized public void run() {
            int c = count;
            c = c-1;
            Sleep.sleep(1000);
            count = c;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }

        //t1: 8
        //t2: 8
        //t1: 6
        //t2: 6
        //t2: 4
        //t1: 4
        //t1: 2
        //t2: 2
        //t1: 0
        //t2: 0

        //t1: 9
        //t1: 8
        //t1: 7
        //t1: 6
        //t1: 5
        //t1: 4
        //t1: 3
        //t1: 2
        //t1: 1
        //t1: 0
    }

    private static void t3() {
        Runnable runnable = () -> System.out.println("runnable");
        Thread thread = new T3Thread(runnable);

        thread.start();
    }

    private static class T3Thread extends Thread {
        T3Thread(Runnable runnable) {
            super(runnable);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("t3Thread");
        }
    }

    private static void t2() {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    Sleep.sleep(Integer.MAX_VALUE);
                }
            }.start();
        }
    }

    private static void t1() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("t1");
            }
        };

        thread.start();
    }
}
