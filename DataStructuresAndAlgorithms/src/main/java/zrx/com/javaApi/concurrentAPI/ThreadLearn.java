package zrx.com.javaApi.concurrentAPI;

import sun.misc.Unsafe;
import zrx.com.MultiThread.MyTools;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description
 * 学习thread
 * <p>
 * Data
 * 2019/12/2 9:28
 *
 * @author zrx
 * @version 1.0
 */

public class ThreadLearn {
    public static void go(){
        new ThreadLearn().thread();
    }

    private void thread(){
        MyTools.printCurrentMethod(true);
        Thread thread;
        threadCommentHead();
    }

    private void threadCommentHead(){
        System.err.println("学习threadCommentHead");
        /**
         * A <i>thread</i> is a thread of execution in a program. The Java
         * Virtual Machine allows an application to have multiple threads of
         * execution running concurrently.
         * 多线程
         * <p>
         * Every thread has a priority. Threads with higher priority are
         * executed in preference to threads with lower priority. Each thread
         * may or may not also be marked as a daemon. When code running in
         * some thread creates a new {@code Thread} object, the new
         * thread has its priority initially set equal to the priority of the
         * creating thread, and is a daemon thread if and only if the
         * creating thread is a daemon.
         * 优先级
         * daemon
         * 继承性
         * <p>
         * When a Java Virtual Machine starts up, there is usually a single
         * non-daemon thread (which typically calls the method named
         * {@code main} of some designated class). The Java Virtual
         * Machine continues to execute threads until either of the following
         * occurs:
         * <ul>
         *     main线程
         * <li>The {@code exit} method of class {@code Runtime} has been
         *     called and the security manager has permitted the exit operation
         *     to take place.
         * <li>All threads that are not daemon threads have died, either by
         *     returning from the call to the {@code run} method or by
         *     throwing an exception that propagates beyond the {@code run}
         *     method.
         *
         调用了 Runtime 类的 exit 方法，并且安全管理器允许退出操作发生。
         非守护线程的所有线程都已停止运行，无论是通过从对 run 方法的调用中返回，
         还是通过抛出一个传播到 run 方法之外的异常。

         * </ul>
         * <p>
         * There are two ways to create a new thread of execution. One is to
         * declare a class to be a subclass of {@code Thread}. This
         * subclass should override the {@code run} method of class
         * {@code Thread}. An instance of the subclass can then be
         * allocated and started. For example, a thread that computes primes
         * larger than a stated value could be written as follows:
         * 创建新执行线程有两种方法。一种方法是将类声明为 Thread 的子类。该子类应
         * 重写 Thread 类的 run 方法。接下来可以分配并启动该子类的实例。例如，计
         * 算大于某一规定值的质数的线程可以写成：
         * <hr><blockquote><pre>
         *     class PrimeThread extends Thread {
         *         long minPrime;
         *         PrimeThread(long minPrime) {
         *             this.minPrime = minPrime;
         *         }
         *
         *         public void run() {
         *             // compute primes larger than minPrime
         *             &nbsp;.&nbsp;.&nbsp;.
         *         }
         *     }
         * </pre></blockquote><hr>
         * <p>
         * The following code would then create a thread and start it running:
         * 然后，下列代码会创建并启动一个线程：
         * <blockquote><pre>
         *     PrimeThread p = new PrimeThread(143);
         *     p.start();
         * </pre></blockquote>
         * <p>
         * The other way to create a thread is to declare a class that
         * implements the {@code Runnable} interface. That class then
         * implements the {@code run} method. An instance of the class can
         * then be allocated, passed as an argument when creating
         * {@code Thread}, and started. The same example in this other
         * style looks like the following:
         * 创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run
         * 方法。然后可以分配该类的实例，在创建 Thread 时作为一个参数来传递并
         * 启动。采用这种风格的同一个例子如下所示：
         * <hr><blockquote><pre>
         *     class PrimeRun implements Runnable {
         *         long minPrime;
         *         PrimeRun(long minPrime) {
         *             this.minPrime = minPrime;
         *         }
         *
         *         public void run() {
         *             // compute primes larger than minPrime
         *             &nbsp;.&nbsp;.&nbsp;.
         *         }
         *     }
         * </pre></blockquote><hr>
         * <p>
         * The following code would then create a thread and start it running:
         * <blockquote><pre>
         *     PrimeRun p = new PrimeRun(143);
         *     new Thread(p).start();
         * </pre></blockquote>
         * <p>
         * Every thread has a name for identification purposes. More than
         * one thread may have the same name. If a name is not specified when
         * a thread is created, a new name is generated for it.
         * 每个线程都有一个标识名，多个线程可以同名。如果线程创建时没有指定标识名
         * ，就会为其生成一个新名称。
         * <p>
         * Unless otherwise noted, passing a {@code null} argument to a constructor
         * or method in this class will cause a {@link NullPointerException} to be
         * thrown.
         *
         * @author  unascribed
         * @see     Runnable
         * @see     Runtime#exit(int)
         * @see     #run()
         * @see     #stop()
         * @since   1.0
         */

        System.err.println("ThreadLocalRandom");
        ThreadLocalRandom random;
        System.out.println("ThreadLocalRandom.current().nextInt(10) = " +
                ThreadLocalRandom.current().nextInt(10));

        Unsafe unsafe;

    }

    private void apiLearn(){
        System.err.println("学习api");
        /***
         * Nested Class Summary
         * 嵌套类
         * Nested Classes Modifier and Type 	Class 	Description
         * static class  	Thread.State
         * A thread state.
         * static interface  	Thread.UncaughtExceptionHandler 当 Thread 因未捕获的异常而突然终止时，
         * 调用处理程序的接口。
         * Interface for handlers invoked when a Thread abruptly terminates due to an uncaught exception.
         *
         * 优先级
         * Field Summary
         * Fields Modifier and Type 	Field 	Description
         * static int 	MAX_PRIORITY
         * The maximum priority that a thread can have.
         * static int 	MIN_PRIORITY
         * The minimum priority that a thread can have.
         * static int 	NORM_PRIORITY
         * The default priority that is assigned to a thread.
         *
         * 构造器
         * Constructor Summary
         * Constructors Constructor 	Description
         * Thread()
         * Allocates a new Thread object.
         * Thread​(Runnable target)
         * Allocates a new Thread object.
         * Thread​(Runnable target, String name)
         * Allocates a new Thread object.
         * Thread​(String name)
         * Allocates a new Thread object.
         * Thread​(ThreadGroup group, Runnable target)
         * Allocates a new Thread object.
         * Thread​(ThreadGroup group, Runnable target, String name)
         * Allocates a new Thread object so that it has target as its run object, has the specified name as its name, and belongs to the thread group referred to by group.
         * Thread​(ThreadGroup group, Runnable target, String name, long stackSize)
         * Allocates a new Thread object so that it has target as its run object, has the specified name as its name, and belongs to the thread group referred to by group, and has the specified stack size.
         * Thread​(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals)
         * Allocates a new Thread object so that it has target as its run object, has the specified name as its name, belongs to the thread group referred to by group, has the specified stackSize, and inherits initial values for inheritable thread-local variables if inheritThreadLocals is true.
         * Thread​(ThreadGroup group, String name)
         * Allocates a new Thread object.
         */

        Thread.State state;
    }

    private void apiLearn2(){
        Thread thread;
//        thread.stop();
        SecurityManager security = System.getSecurityManager();

        System.err.println("学习stop");

        //    public final void stop() {
        //拿到安全管理器
        //        SecurityManager security = System.getSecurityManager();
        //        if (security != null) {
        //
        //调用stop的线程，如main，是否有权限访问this线程
        //            checkAccess();
        //
        //this-要被stop的线程。currentThread-如main线程。检查权限
        //            if (this != Thread.currentThread()) {
        //                security.checkPermission(SecurityConstants.STOP_THREAD_PERMISSION);
        //            }
        //        }
        //
        //线程!=new状态。不能改魔数
        //即可能处于 运行、阻塞、等待
        //        // A zero status value corresponds to "NEW", it can't change to
        //        // not-NEW because we hold the lock.
        //        if (threadStatus != 0) {
        //将suspend的线程唤醒
        //            resume(); // Wake up thread if it was suspended; no-op otherwise
        //        }
        //
        //        // The VM can handle all thread states
        //stop0(this,ThreadDeath)
        //        stop0(new ThreadDeath());
        //    }

        System.err.println("学习ThreadDeath");
//        new ThreadDeath();
        //public class ThreadDeath extends Error {
        //    private static final long serialVersionUID = -4417128565033088268L;
        //}

        /**
         * An instance of {@code ThreadDeath} is thrown in the victim thread
         * when the (deprecated) {@link Thread#stop()} method is invoked.
         *
         * <p>An application should catch instances of this class only if it
         * must clean up after being terminated asynchronously.  If
         * {@code ThreadDeath} is caught by a method, it is important that it
         * be rethrown so that the thread actually dies.
         *
         * <p>The {@linkplain ThreadGroup#uncaughtException top-level error
         * handler} does not print out a message if {@code ThreadDeath} is
         * never caught.
         *
         * <p>The class {@code ThreadDeath} is specifically a subclass of
         * {@code Error} rather than {@code Exception}, even though it is a
         * "normal occurrence", because many applications catch all
         * occurrences of {@code Exception} and then discard the exception.
         *
         * @since   1.0
         */

    }


}
