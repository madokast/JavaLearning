package thread;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" in RunnableTest");
    }
}
