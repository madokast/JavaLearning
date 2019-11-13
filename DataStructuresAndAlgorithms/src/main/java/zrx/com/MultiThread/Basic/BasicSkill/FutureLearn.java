package zrx.com.MultiThread.Basic.BasicSkill;

import org.junit.internal.runners.statements.RunAfters;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyTimer;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * 学习Java future 类方法
 * @see FutureLearn::smallDemo
 *
 * Callable类 —— runnable run()的升级
 *  * A task that returns a result and may throw an exception.
 *  * Implementors define a single method with no arguments called
 *  * {@code call}.
 *  *
 *  * <p>The {@code Callable} interface is similar to {@link
 *  * java.lang.Runnable}, in that both are designed for classes whose
 *  * instances are potentially executed by another thread.  A
 *  * {@code Runnable}, however, does not return a result and cannot
 *  * throw a checked exception.
 *  *
 *  * <p>The {@link Executors} class contains utility methods to
 *  * convert from other common forms to {@code Callable} classes.
 *
 *  -------------------------------------------------------------------------------------
 *
 *   关键字：the {@code get} methods will block if the computation has not yet completed
 *
 *  * A cancellable asynchronous computation.  This class provides a base
 *  * implementation of {@link Future}, with methods to start and cancel
 *  * a computation, query to see if the computation is complete, and
 *  * retrieve the result of the computation.  The result can only be
 *  * retrieved when the computation has completed; the {@code get}
 *  * methods will block if the computation has not yet completed.  Once
 *  * the computation has completed, the computation cannot be restarted
 *  * or cancelled (unless the computation is invoked using
 *  * {@link #runAndReset}).
 *  public class FutureTask<V> implements RunnableFuture<V>
 *
 *
 *  --------------------------------------------------------------------------------------
 *
 *   将Future和Runnable绑定，所以说"A {@link Future} that is {@link Runnable}."
 *
 *  * A {@link Future} that is {@link Runnable}. Successful execution of
 *  * the {@code run} method causes completion of the {@code Future}
 *  * and allows access to its results.
 *  * @see FutureTask
 *  * @see Executor
 *  * @since 1.6
 *  * @author Doug Lea
 *  * @param <V> The result type returned by this Future's {@code get} method
 *  public interface RunnableFuture<V> extends Runnable, Future<V>
 *
 *
 *  --------------------------------------------------------------------------------------
 *  Future 接口
 *  * A {@code Future} represents the result of an asynchronous              呈现异步计算的结果
 *  * computation.  Methods are provided to check if the computation is      有对计算的控制能力
 *  * complete, to wait for its completion, and to retrieve the result of    是否完成？等待完成？获得结果
 *  * the computation.  The result can only be retrieved using method        通过get 获得结果
 *  * {@code get} when the computation has completed, blocking if            这是个阻塞方法（废话
 *  * necessary until it is ready.  Cancellation is performed by the         cancel() 方法可以取消执行
 *  * {@code cancel} method.  Additional methods are provided to
 *  * determine if the task completed normally or was cancelled. Once a
 *  * computation has completed, the computation cannot be cancelled.        计算完成后，是无法cancel的
 *  * If you would like to use a {@code Future} for the sake                 如果你仅仅是想要对计算能cancel
 *  * of cancellability but not provide a usable result, you can             那就返回null即可
 *  * declare types of the form {@code Future<?>} and
 *  * return {@code null} as a result of the underlying task.
 *  *
 *  * <p><b>Sample Usage</b> (Note that the following classes are all
 *  * made-up.)
 *  *
 *  *
 *  * The {@link FutureTask} class is an implementation of {@code Future} that
 *  * implements {@code Runnable}, and so may be executed by an {@code Executor}.
 *  * For example, the above construction with {@code submit} could be replaced by:
 *  * <pre> {@code
 *  * FutureTask<String> future = new FutureTask<>(task);
 *  * executor.execute(future);}</pre>
 *  *
 *  * <p>Memory consistency effects: Actions taken by the asynchronous computation
 *  * <a href="package-summary.html#MemoryVisibility"> <i>happen-before</i></a>
 *  * actions following the corresponding {@code Future.get()} in another thread.
 *  *
 *  * @see FutureTask
 *  * @see Executor
 *  * @since 1.5
 *  * @author Doug Lea
 *  * @param <V> The result type returned by this Future's {@code get} method
 *
 *  public interface Future<V>
 *     试图取消对此任务的执行。如果任务已完成、或已取消，或者由于某些其他原因而无法取消，
 *     则此尝试将失败。当调用 cancel 时，如果调用成功，而此任务尚未启动，则此任务将永不运行。
 *     如果任务已经启动，则 mayInterruptIfRunning 参数确定是否应该以试图停止任务的方式来中断执行此任务的线程。
 *     此方法返回后，对 isDone() 的后续调用将始终返回 true。如果此方法返回 true，则对 isCancelled() 的后续调用将始终返回 true。
 *     参数：
 *         mayInterruptIfRunning - 如果应该中断执行此任务的线程，则为 true；否则允许正在运行的任务运行完成
 *     返回：
 *         如果无法取消任务，则返回 false，这通常是由于它已经正常完成；否则返回 true
 *      boolean cancel(boolean mayInterruptIfRunning);
 *      boolean isDone();
 *      V get() throws InterruptedException, ExecutionException;
 *
 *
 * <p>
 * Data
 * 2019/11/11 16:33
 *
 * @author zrx
 * @version 1.0
 */

public class FutureLearn {
    public static void learn(){
        System.err.println("FutureLearn");
        new FutureLearn().smallDemo();
        new FutureLearn().waitToLong();
    }

    private void smallDemo(){
        MyTools.printCurrentMethod(true);
        //我需要拿到线程的返回值
        //实现callable的call方法，类似run()方法
        //不过可以有返回值，也可以抛出异常
        Callable<Integer> callable = ()->{
            MyTools.sleepSelf(500);
            System.err.println( Thread.currentThread().getName()+":子线程千辛万苦，计算出了返回值");
            return 250;
        };

        //用callable构造一个futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        //FutureTask有runnable接口，所以放入thread中执行
        new Thread(futureTask,"辛辛苦苦的子线程").start();

        //主程序可以随时查看，是否运行完
        if(!futureTask.isDone()){
            System.err.println(Thread.currentThread().getName()+":主程序询问子程序是否执行完成。但是没有");
        }

       Integer ans = null;
        try {
            MyTimer.runtimeBack();
            ans =  futureTask.get();
            System.err.println("futureTask.get()是一个阻塞方法，运行"+MyTimer.runtimeBack()+"ms");
        }catch (Exception e){e.printStackTrace();}

        System.err.println(Thread.currentThread().getName()+":主程序拿到了计算结果。是"+ans);

        return;
    }

    private void waitToLong(){
        MyTools.printCurrentMethod(true);
        //等不耐烦了

        Callable<Object> callable = ()->{
            MyTools.sleepSelf(1000000);
            System.err.println(Thread.currentThread().getName()+"：运行结束");
            return null;
        };

        FutureTask<Object> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);
        thread.setName("就是出不来");
        thread.setDaemon(true);

        thread.start();

        try {
            futureTask.get(500, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            //no
        }

        System.err.println(Thread.currentThread().getName()+":就是不出来，不等了");

    }
}

