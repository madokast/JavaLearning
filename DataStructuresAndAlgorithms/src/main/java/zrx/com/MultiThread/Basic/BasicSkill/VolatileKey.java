package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

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
