package ichiwanTest.test;

import ichiwan.util.Tools;
import org.junit.Test;

import javax.tools.Tool;

public class ThreadExitTest {
    @Test
    public void run(){
        final Thread thread = new Thread(() -> {
            while (true) {
                System.out.print("A");
            }
        });
        thread.start();
        final Thread thread1 = new Thread(() -> {
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.exit(-1);
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        }catch (Exception e){e.printStackTrace();}


    }
}
