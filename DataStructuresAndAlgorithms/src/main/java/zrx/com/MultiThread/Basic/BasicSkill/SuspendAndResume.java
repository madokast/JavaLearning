package zrx.com.MultiThread.Basic.BasicSkill;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyTimer;

/**
 * Description
 * SuspendAndResume
 * <p>
 * Data
 * 2019/12/2 11:13
 *
 * @author zrx
 * @version 1.0
 */

public class SuspendAndResume {
    public static void go(){
        new SuspendAndResume().suspendAndResumeTest();
    }

    @SuppressWarnings("all")
    private void suspendAndResumeTest(){
        MyTools.printCurrentMethod(true);
        System.err.println("注意mian线程和thread线程，不能用相同的输出流，不然会发生死锁");
        final long startTime = System.currentTimeMillis();

        Thread thread = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName()+"正在运行[" + (System.currentTimeMillis()-startTime));
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    System.out.println(Thread.currentThread().getName()+"退出[" + (System.currentTimeMillis()-startTime));
                }
            }
        });
        thread.setDaemon(true);
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
        System.err.println("        主线程启动thread["+ (System.currentTimeMillis()-startTime));
        thread.start();

        System.err.println("        主线程休息0.5秒["+ (System.currentTimeMillis()-startTime));
        MyTools.sleepSelf(250);
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
        MyTools.sleepSelf(250);

        System.err.println("        主线程挂起thread["+ (System.currentTimeMillis()-startTime));
        thread.suspend();

        MyTools.sleepSelf(500);
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
        System.err.println("        主线程休息0.5秒["+ (System.currentTimeMillis()-startTime));
        MyTools.sleepSelf(500);

        System.err.println("        主线程重启thread["+ (System.currentTimeMillis()-startTime));
        thread.resume();
        MyTools.sleepSelf(100);
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
        System.err.println("        主线程休息0.5秒["+ (System.currentTimeMillis()-startTime));
        MyTools.sleepSelf(500);

        System.err.println("        主线程退出");
        thread.interrupt();
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
        MyTools.sleepSelf(100);
        System.err.println("        thread状态是"+thread.getState()+"["+ (System.currentTimeMillis()-startTime));
    }
}
