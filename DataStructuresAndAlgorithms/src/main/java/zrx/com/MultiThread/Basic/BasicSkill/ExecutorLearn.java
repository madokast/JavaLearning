package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyTimer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Description
 * 学习 Executor
 * <p>
 * Data
 * 2019/11/11 20:01
 *
 * @author zrx
 * @version 1.0
 */

public class ExecutorLearn {
    public static void learn(){
        new ExecutorLearn().threadPool();
    }

    private void threadPool(){
        MyTools.printCurrentMethod(true);
        MyTimer.runtime();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Future<String>> futureSet = new HashSet<>();

        futureSet.add(executorService.submit(getCallable(0)));
        futureSet.add(executorService.submit(getCallable(150)));
        futureSet.add(executorService.submit(getCallable(300)));
        futureSet.add(executorService.submit(getCallable(450)));
        futureSet.add(executorService.submit(getCallable(600)));
        futureSet.add(executorService.submit(getCallable(750)));
        futureSet.add(executorService.submit(getCallable(900)));

        Future<String> f = null;
        while (futureSet.size()!=0){
            for (Future<String> future : futureSet) {
                if(future.isDone()){
                    try {
                        System.err.println(Thread.currentThread().getName()+":有一个任务执行完了。它说"+future.get());
                    }catch (Exception e){e.printStackTrace();}

                    f = future;
                }
            }
            if(f!=null){
                futureSet.remove(f);
                f = null;
            }
        }

        MyTimer.runtime();
    }

    private Callable<String> getCallable(int sleepMs){
        return ()->{
            MyTools.sleepSelf(sleepMs);
            return sleepMs+"执行完毕于["+System.currentTimeMillis()+"ms]";
        };
    }

    private void 学习Executor(Executor executor){
        // 只有一个方法
        //void execute(Runnable command);
        //传入一个runnable 它在未来会执行

        ///**
        // * An object that executes submitted {@link Runnable} tasks. This
        // * interface provides a way of decoupling task submission from the
        // * mechanics of how each task will be run, including details of thread
        // * use, scheduling, etc.  An {@code Executor} is normally used
        // * instead of explicitly creating threads. For example, rather than
        // * invoking {@code new Thread(new RunnableTask()).start()} for each
        // * of a set of tasks, you might use:
        // *
        // * <pre> {@code
        // * Executor executor = anExecutor();
        // * executor.execute(new RunnableTask1());
        // * executor.execute(new RunnableTask2());
        // * ...}</pre>
        // *
        // * However, the {@code Executor} interface does not strictly require
        // * that execution be asynchronous. In the simplest case, an executor
        // * can run the submitted task immediately in the caller's thread:
        // *
        // * <pre> {@code
        // * class DirectExecutor implements Executor {
        // *   public void execute(Runnable r) {
        // *     r.run();
        // *   }
        // * }}</pre>
        // *
        // * More typically, tasks are executed in some thread other than the
        // * caller's thread.  The executor below spawns a new thread for each
        // * task.
        // *
        // * <pre> {@code
        // * class ThreadPerTaskExecutor implements Executor {
        // *   public void execute(Runnable r) {
        // *     new Thread(r).start();
        // *   }
        // * }}</pre>
        // *
        // * Many {@code Executor} implementations impose some sort of
        // * limitation on how and when tasks are scheduled.  The executor below
        // * serializes the submission of tasks to a second executor,
        // * illustrating a composite executor.
        // *
        // * <pre> {@code
        // * class SerialExecutor implements Executor {
        // *   final Queue<Runnable> tasks = new ArrayDeque<>();
        // *   final Executor executor;
        // *   Runnable active;
        // *
        // *   SerialExecutor(Executor executor) {
        // *     this.executor = executor;
        // *   }
        // *
        // *   public synchronized void execute(Runnable r) {
        // *     tasks.add(() -> {
        // *       try {
        // *         r.run();
        // *       } finally {
        // *         scheduleNext();
        // *       }
        // *     });
        // *     if (active == null) {
        // *       scheduleNext();
        // *     }
        // *   }
        // *
        // *   protected synchronized void scheduleNext() {
        // *     if ((active = tasks.poll()) != null) {
        // *       executor.execute(active);
        // *     }
        // *   }
        // * }}</pre>
        // *
        // * The {@code Executor} implementations provided in this package
        // * implement {@link ExecutorService}, which is a more extensive
        // * interface.  The {@link ThreadPoolExecutor} class provides an
        // * extensible thread pool implementation. The {@link Executors} class
        // * provides convenient factory methods for these Executors.
        // *
        // * <p>Memory consistency effects: Actions in a thread prior to
        // * submitting a {@code Runnable} object to an {@code Executor}
        // * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
        // * its execution begins, perhaps in another thread.
        // *
        // * @since 1.5
        // * @author Doug Lea
        // */


        //执行已提交的 Runnable 任务的对象。
        // 此接口提供一种将任务提交与每个任务将如何运行的机制
        // （包括线程使用的细节、调度等）分离开来的方法。
        // 通常使用 Executor 而不是显式地创建线程。
        // 例如，可能会使用以下方法，
        // 而不是为一组任务中的每个任务调用 new Thread(new(RunnableTask())).start()：
    }

    private void 学习ExecutorService(ExecutorService executorService){
        ///**
        // * An {@link Executor} that provides methods to manage termination and
        // 一个Executor 管理终止 产生future
        // * methods that can produce a {@link Future} for tracking progress of
        // * one or more asynchronous tasks.
        // *
        // * <p>An {@code ExecutorService} can be shut down, which will cause
        // 可以被被关闭。就不再接受任务
        // * it to reject new tasks.  Two different methods are provided for
        // 两个关闭方法。
        // * shutting down an {@code ExecutorService}. The {@link #shutdown}
        // * method will allow previously submitted tasks to execute before
        // * terminating, while the {@link #shutdownNow} method prevents waiting
        // * tasks from starting and attempts to stop currently executing tasks.
        // * Upon termination, an executor has no tasks actively executing, no
        // * tasks awaiting execution, and no new tasks can be submitted.  An
        // * unused {@code ExecutorService} should be shut down to allow
        // * reclamation of its resources.
        // 用完应该关闭
        // *
        // * <p>Method {@code submit} extends base method {@link
        // * Executor#execute(Runnable)} by creating and returning a {@link Future}
        // * that can be used to cancel execution and/or wait for completion.
        // * Methods {@code invokeAny} and {@code invokeAll} perform the most
        // * commonly useful forms of bulk execution, executing a collection of
        // * tasks and then waiting for at least one, or all, to
        // * complete. (Class {@link ExecutorCompletionService} can be used to
        // * write customized variants of these methods.)
        // *
        // * <p>The {@link Executors} class provides factory methods for the
        // * executor services provided in this package.
        // *
        // * <h3>Usage Examples</h3>
        // *
        // * Here is a sketch of a network service in which threads in a thread
        // * pool service incoming requests. It uses the preconfigured {@link
        // * Executors#newFixedThreadPool} factory method:
        // *
        // * <pre> {@code
        // * class NetworkService implements Runnable {
        // *   private final ServerSocket serverSocket;
        // *   private final ExecutorService pool;
        // *
        // *   public NetworkService(int port, int poolSize)
        // *       throws IOException {
        // *     serverSocket = new ServerSocket(port);
        // *     pool = Executors.newFixedThreadPool(poolSize);
        // *   }
        // *
        // *   public void run() { // run the service
        // *     try {
        // *       for (;;) {
        // *         pool.execute(new Handler(serverSocket.accept()));
        // *       }
        // *     } catch (IOException ex) {
        // *       pool.shutdown();
        // *     }
        // *   }
        // * }
        // *
        // * class Handler implements Runnable {
        // *   private final Socket socket;
        // *   Handler(Socket socket) { this.socket = socket; }
        // *   public void run() {
        // *     // read and service request on socket
        // *   }
        // * }}</pre>
        // *
        // * The following method shuts down an {@code ExecutorService} in two phases,
        // * first by calling {@code shutdown} to reject incoming tasks, and then
        // * calling {@code shutdownNow}, if necessary, to cancel any lingering tasks:
        // *
        // * <pre> {@code
        // * void shutdownAndAwaitTermination(ExecutorService pool) {
        // *   pool.shutdown(); // Disable new tasks from being submitted
        // *   try {
        // *     // Wait a while for existing tasks to terminate
        // *     if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
        // *       pool.shutdownNow(); // Cancel currently executing tasks
        // *       // Wait a while for tasks to respond to being cancelled
        // *       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
        // *           System.err.println("Pool did not terminate");
        // *     }
        // *   } catch (InterruptedException ie) {
        // *     // (Re-)Cancel if current thread also interrupted
        // *     pool.shutdownNow();
        // *     // Preserve interrupt status
        // *     Thread.currentThread().interrupt();
        // *   }
        // * }}</pre>
        // *
        // * <p>Memory consistency effects: Actions in a thread prior to the
        // * submission of a {@code Runnable} or {@code Callable} task to an
        // * {@code ExecutorService}
        // * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
        // * any actions taken by that task, which in turn <i>happen-before</i> the
        // * result is retrieved via {@code Future.get()}.
        // *
        // * @since 1.5
        // * @author Doug Lea
        // */

        // 方法摘要
        // boolean 	awaitTermination(long timeout, TimeUnit unit)
        //          请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行。
        //<T> List<Future<T>>
        //	invokeAll(Collection<? extends Callable<T>> tasks)
        //          执行给定的任务，当所有任务完成时，返回保持任务状态和结果的 Future 列表。
        //<T> List<Future<T>>
        //	invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
        //          执行给定的任务，当所有任务完成或超时期满时（无论哪个首先发生），返回保持任务状态和结果的 Future 列表。
        //<T> T
        //	invokeAny(Collection<? extends Callable<T>> tasks)
        //          执行给定的任务，如果某个任务已成功完成（也就是未抛出异常），则返回其结果。
        //<T> T
        //	invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
        //          执行给定的任务，如果在给定的超时期满前某个任务已成功完成（也就是未抛出异常），则返回其结果。
        // boolean 	isShutdown()
        //          如果此执行程序已关闭，则返回 true。
        // boolean 	isTerminated()
        //          如果关闭后所有任务都已完成，则返回 true。
        // void 	shutdown()
        //          启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
        // List<Runnable> 	shutdownNow()
        //          试图停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
        //<T> Future<T>
        //	submit(Callable<T> task)
        //          提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future。
        // Future<?> 	submit(Runnable task)
        //          提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
        //<T> Future<T>
        //	submit(Runnable task, T result)
        //          提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
    }

    private void 学习ScheduledExecutorService(ScheduledExecutorService scheduledExecutorService){
        //一个 ExecutorService，可安排在给定的延迟后运行或定期执行的命令。
        // 方法摘要
        //<V> ScheduledFuture<V>
        //	schedule(Callable<V> callable, long delay, TimeUnit unit)
        //          创建并执行在给定延迟后启用的 ScheduledFuture。
        // ScheduledFuture<?> 	schedule(Runnable command, long delay, TimeUnit unit)
        //          创建并执行在给定延迟后启用的一次性操作。
        // ScheduledFuture<?> 	scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
        //          创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，然后在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
        // ScheduledFuture<?> 	scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
        //          创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟。
    }

    private void 学习AbstractExecutorService(AbstractExecutorService abstractExecutorService){
        //提供 ExecutorService 执行方法的默认实现。
        // 此类使用 newTaskFor 返回的 RunnableFuture
        // 实现 submit、invokeAny 和 invokeAll 方法，
        // 默认情况下，RunnableFuture 是此包中提供的 FutureTask 类。
        // 例如，submit(Runnable) 的实现创建了一个关联 RunnableFuture 类，
        // 该类将被执行并返回。子类可以重写 newTaskFor 方法，
        // 以返回 FutureTask 之外的 RunnableFuture 实现。
    }

    private void 学习ThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor){
        //一个 ExecutorService，它使用可能的几个池线程之一执行每个提交的任务，通常使用 Executors 工厂方法配置。
        //线程池
    }

    private void 学习Executors(Executors executors){
        //工厂方法。提供线程池
    }
}
