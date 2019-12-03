package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyRequire;
import zrx.com.leetcode.utils.MyTimer;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description
 * 完全不知所云CompletionStage
 * <p>
 * Data
 * 2019/12/1 21:37
 *
 * @author zrx
 * @version 1.0
 */

public class CompletionStageLearn {
    public static void go(){
        new CompletionStageLearn().test1();
        new CompletionStageLearn().test2();
        new CompletionStageLearn().test3();
    }

    private void test3(){
        MyTools.printCurrentMethod(true);
        System.err.println("CompletionStageLearn异常测试");

        CompletableFuture.supplyAsync(Math::random).thenApply(
                e->{
                    System.out.println("拿到了" + e);
//                    MyRequire.throwRunTimeException("中途异常"); //已注释
                    return e;//不会执行了吧
                }
        ).thenApply(
                e->{
                    System.out.println("这里应该不会执行");
                    return e;
                }
        ).whenComplete((x,e)->{
            System.out.println("拿到了" + x);
            System.out.println("异常是" + (e==null?"null":e.getMessage()));
        }).join();
    }

    private void test2(){
        MyTools.printCurrentMethod(true);
        System.err.println("学习CompletionStage 测试2 没有异步");



        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+ ": 提供者吐出数字3");
            MyTools.sleepSelf(500);
            return 3;
        },executorService).thenApply(e -> {
            System.out.println(Thread.currentThread().getName()+ ": 应用者拿到了" + e);
            System.out.println(Thread.currentThread().getName()+ ": 翻倍并传下去");
            MyTools.sleepSelf(500);
            return 2 * e;
        }).thenAccept(e -> {
            System.out.println(Thread.currentThread().getName()+ ": 消费者拿到了" + e);
            System.out.println(Thread.currentThread().getName()+ ": 那就结束了");
            MyTools.sleepSelf(500);
        }).whenComplete((r,e)->{
            if(e==null){
                MyTools.sleepSelf(500);
                System.out.println(Thread.currentThread().getName()+ ": 整个阶段没有异常");
            } else
                e.printStackTrace();
        });

        System.out.println(Thread.currentThread().getName()+ "------------主线程继续做替他的事情");
        MyTools.sleepSelf(500);
        System.out.println(Thread.currentThread().getName()+ "------------主线程休息了0.5秒");
        System.out.println(Thread.currentThread().getName()+ "------------主线程打算join等待一切");

        CompletableFuture.allOf(voidCompletableFuture).join();

        System.out.println(Thread.currentThread().getName()+ "------------主线程：等待结束");


    }

    private void test1(){
        MyTools.printCurrentMethod(true);
        System.err.println("学习CompletionStage 测试1");
        //public interface CompletionStage<T>
        //首先是一个接口
        CompletionStage completionStage;

        //public class CompletableFuture<T> implements Future<T>, CompletionStage<T>
        //上面的实现类
        CompletableFuture completableFuture;

        //
        CompletableFuture.AsynchronousCompletionTask completionTask;

        CompletableFuture.supplyAsync(Math::random).thenApply(x->x*x).whenComplete((x,e)->{/*x返回值,e异常*/});

        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+ ": 提供者吐出数字3");
            MyTools.sleepSelf(500);
            return 3;
        },executorService).thenApplyAsync(e -> {
            System.out.println(Thread.currentThread().getName()+ ": 应用者拿到了" + e);
            System.out.println(Thread.currentThread().getName()+ ": 翻倍并传下去");
            MyTools.sleepSelf(500);
            return 2 * e;
        }).thenAcceptAsync(e -> {
            System.out.println(Thread.currentThread().getName()+ ": 消费者拿到了" + e);
            System.out.println(Thread.currentThread().getName()+ ": 那就结束了");
            MyTools.sleepSelf(500);
        }).whenCompleteAsync((r,e)->{
           if(e==null){
               MyTools.sleepSelf(500);
               System.out.println(Thread.currentThread().getName()+ ": 整个阶段没有异常");
           } else
               e.printStackTrace();
        });

        System.out.println(Thread.currentThread().getName()+ "------------主线程继续做替他的事情");
        MyTools.sleepSelf(500);
        System.out.println(Thread.currentThread().getName()+ "------------主线程休息了0.5秒");
        System.out.println(Thread.currentThread().getName()+ "------------主线程打算join等待一切");

        CompletableFuture.allOf(voidCompletableFuture).join();

        System.out.println(Thread.currentThread().getName()+ "------------主线程：等待结束");

        //提供者吐出数字3
        //main------------主线程继续做替他的事情
        //ForkJoinPool.commonPool-worker-5: 应用者拿到了3
        //ForkJoinPool.commonPool-worker-5: 翻倍并传下去
        //main------------主线程休息了0.5秒
        //main------------主线程打算join等待一切
        //ForkJoinPool.commonPool-worker-5: 消费者拿到了6
        //ForkJoinPool.commonPool-worker-5: 那就结束了
        //ForkJoinPool.commonPool-worker-5: 整个阶段没有异常
        //main------------主线程：等待结束
    }
}
