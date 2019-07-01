package web.fileSend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 流不正常关闭的问题
 * "D:\Program Files\jdk-12.0.1\bin\java.exe" "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar=56382:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201907 web.fileSend.Work
 * work finished
 * server ready
 * client ready
 * client send 1024
 * client send 1024
 * 。。。
 * client send 846
 * server get 846
 * client send finished
 * server get finished
 *
 * 输入流的 read方法 阻塞问题
 *  在某些输入可用之前，此方法将被阻塞
 */

public class Work {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->Server.main(null));
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.submit(()->Client.main(null));

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all finished");
        executorService.shutdown();
//        System.exit(0);
    }
}
