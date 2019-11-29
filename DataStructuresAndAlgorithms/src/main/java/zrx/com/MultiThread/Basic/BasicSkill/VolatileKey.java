package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 学习volatile关键字
 * <p>
 * Data
 * 2019/11/25 22:01
 *
 * @author zrx
 * @version 1.0
 */

public class VolatileKey {
    public static void test(){
        new VolatileKey().NoVolatileTest();
        new VolatileKey().HasVolatileTest();
        try {
            new VolatileKey().reRange();
        }catch (Exception e){e.printStackTrace();}
    }



    private static int x,y,a,b,c,d,e,f,count;
    private void reRange() throws InterruptedException{

        MyTools.printCurrentMethod(true);
        System.out.println("测试跳过");
        System.out.println("往期测试结果：" + "14294次: x, y = 0, 0");
        System.err.println("CPU发生了重排序");

//        ArrayList arrayList;

        //这个测试太耗时间
        if(false){
            count = 0;

            for(;;){
                count++;
                x = 0;
                y = 0;
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                e = 0;
                f = 0;

                Thread t1 = new Thread(()->{
                    c = 100;
                    a = 1;
                    d = 200;
                    x = b;
                });
                Thread t2 = new Thread(()->{
                    e = 1000;
                    b = 1;
                    f = 2000;
                    y = a;
                });
                t1.start();
                t2.start();

                t1.join();
                t2.join();

                System.out.println(count+"次: " + "x, y = " + x+", "+y);
                if(x==0&&y==0){
                    System.err.println("CPU发生了重排序");
                    break;
                }
            }
        }
    }


    private void HasVolatileTest(){
        MyTools.printCurrentMethod(true);
        HasVolatile hasVolatile = new HasVolatile();
        Thread thread = new Thread(()->hasVolatile.run());

        thread.setDaemon(true);
        thread.start();
        System.out.println("main: 让线程开始死循环");
        MyTools.sleepSelf(100);
        System.out.println("main: 尝试停止死循环");
        hasVolatile.setStop(true);
        System.out.println("main: 发出了停止信号于"+System.currentTimeMillis());
        MyTools.sleepSelf(500);
        System.out.println("main: 现在过去了500ms");
        if(thread.isAlive()){
            System.out.println("main: 居然还没有停下来");
        }else {
            System.out.println("main: 停下来了呢");
        }
    }

    private void NoVolatileTest(){
        MyTools.printCurrentMethod(true);
        NoVolatile noVolatile = new NoVolatile();
        Thread thread = new Thread(()->noVolatile.run());

        thread.setDaemon(true);
        thread.start();
        System.out.println("main: 让线程开始死循环");
        MyTools.sleepSelf(100);
        System.out.println("main: 尝试停止死循环");
        noVolatile.setStop(true);
        System.out.println("main: 发出了停止信号于"+System.currentTimeMillis());
        MyTools.sleepSelf(500);
        System.out.println("main: 现在过去了500ms");
        if(thread.isAlive()){
            System.out.println("main: 居然还没有停下来");
        }else {
            System.out.println("main: 停下来了呢");
        }
    }

    private class NoVolatile{
        private boolean stop = false;

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        public void run(){
            System.out.println("thread: 开始死循环");
            while (stop==false){}
            System.out.println("thread: 死循环停止于"+System.currentTimeMillis());
        }
    }

    private class HasVolatile{
        private volatile boolean stop = false;

        public void setStop(boolean stop) {
            this.stop = stop;
        }


        public void run(){
            System.out.println("thread: 开始死循环");
            while (stop==false){}
            System.out.println("thread: 死循环停止于"+System.currentTimeMillis());
        }
    }

}
