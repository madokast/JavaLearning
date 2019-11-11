package zrx.com.MultiThread;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/11/9 17:44
 *
 * @author zrx
 * @version 1.0
 */

public class MyTools {
    /**
     * 自己睡ms毫秒
     * @param ms 毫秒
     */
    public static void sleepSelf(int ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 一次大约0.01s。不会抛出异常
     * @param times 次数
     */
    public static void hardWork(int times){
        for (int i = 0; i < times; i++) {
            int sum = 0;
            for (int j = 0; j < (Integer.MAX_VALUE - times)/100 ; j++) {
                sum+=j;
            }
        }
    }
}
