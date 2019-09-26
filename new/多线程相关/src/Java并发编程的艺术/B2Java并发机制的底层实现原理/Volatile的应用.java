package Java并发编程的艺术.B2Java并发机制的底层实现原理;

import Java并发编程的艺术.Tools.Timer;

import java.util.Random;

public class Volatile的应用 {
    private static int a = 0;
    private static volatile int b = 0;
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        noVolatile();
//        hasVolatile();
    }

    private static void hasVolatile()throws InterruptedException  {
        Thread thread1 = new Thread(() -> {
            opB(1);
        });
        Thread thread2 = new Thread(() -> {
            opB(10);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void opB(int sleep) {
        while (b < 100) {
            int temp = b;
            temp = temp + 1;
            Timer.sleep(sleep);
            b = temp;
            System.out.println(Thread.currentThread().getName()+" b= " + b);
        }
    }

    private static void noVolatile() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while(true){
                final int i = random.nextInt(10);
                System.out.println("---------write "+i+"----------");
                setA(i);
                Timer.sleep(10);
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println("a = " + a);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void opA(int sleep){
        while (a < 100) {
            int temp = a;
            temp = temp + 1;
            Timer.sleep(sleep);
            a = temp;
            System.out.println(Thread.currentThread().getName()+" a = " + a);
        }
    }

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static void setA(int a) {
        Volatile的应用.a = a;
    }

    public static void setB(int b) {
        Volatile的应用.b = b;
    }
}
