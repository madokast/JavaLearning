package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Description
 * ForkJoinPool 快速学习
 * <p>
 * Data
 * 2019/11/26 14:32
 *
 * @author zrx
 * @version 1.0
 */

public class ForkJoinPoolTest {
    public static void go(){
        new ForkJoinPoolTest().RecursiveActionTest();
        new ForkJoinPoolTest().RecursiveTaskTest();
    }

    private void RecursiveTaskTest(){
        MyTools.printCurrentMethod(true);

        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        final Summer summer = new Summer(5);

        forkJoinPool.submit(summer);

        MyTools.sleepSelf(100);

        forkJoinPool.shutdown();

        while (!forkJoinPool.isTerminated()){
            MyTools.sleepSelf(10);
        }

    }

    private void RecursiveActionTest(){
        MyTools.printCurrentMethod(true);

        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        final Printer action = new Printer(0, 12);

        forkJoinPool.submit(action);

//        try {
//            forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        MyTools.sleepSelf(100);
        forkJoinPool.shutdown();
        while (!forkJoinPool.isTerminated()){
            MyTools.sleepSelf(10);
        }
    }

}

class Printer extends RecursiveAction{
    private int startIncluding;
    private int endExcluding;

    public Printer(int startIncluding, int endExcluding) {
        this.startIncluding = startIncluding;
        this.endExcluding = endExcluding;
    }

    @Override
    protected void compute() {
        if(endExcluding-startIncluding<=3){
            System.out.println(Thread.currentThread().getName()+"说，这是一个小任务，我自己办" +"["+System.currentTimeMillis());
            //执行任务
            for (int i = startIncluding; i < endExcluding; i++) {
                System.out.println(Thread.currentThread().getName()+"打印: " + i+"["+System.currentTimeMillis());
                MyTools.hardWork(10);
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"说，这是一个大任务，分支出去给他人做" +"["+System.currentTimeMillis());
            //分支任务
            int middle = (startIncluding+endExcluding)/2;
            new Printer(startIncluding,middle).fork();
            new Printer(middle,endExcluding).fork();

            System.out.println(Thread.currentThread().getName()+"说，分派完成" +"["+System.currentTimeMillis());
        }
    }
}

class Summer extends RecursiveTask<Integer>{
    volatile int times;

    public Summer(int times){
        this.times = times;
    }

    @Override
    protected Integer compute() {
        if(times>0){
            System.out.println(Thread.currentThread().getName()+"说，"+times+"是一个大任务，分支出去给他人做" +"["+System.currentTimeMillis());
            //分支任务
            times--;
            final Summer s1 = new Summer(times);
            times--;
            final Summer s2 = new Summer(times);
            System.out.println(Thread.currentThread().getName()+"说，分派完成" +"["+System.currentTimeMillis());
            s1.fork();
            s2.fork();
            return s1.join()+s2.join();

        }else {
            System.out.println(Thread.currentThread().getName()+"说，"+times+"是一个小任务，我自己办" +"["+System.currentTimeMillis());
            //执行任务
            MyTools.hardWork(10);
            return new Random().nextInt(100);
        }
    }
}
