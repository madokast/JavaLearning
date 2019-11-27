package zrx.com.MultiThread;

/**
 * Description
 * zrx.com.MultiThread
 * <p>
 * Data
 * 2019/11/9 17:44
 *
 * @author zrx
 * @version 1.0
 */

public class MyTools {
    /**
     * 打印调用这个方法的前一个方法名
     * 类名+方法名
     */
    public static void printCurrentMethod(boolean isErr){
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        final StackTraceElement traceElement = stackTrace[2];

        StringBuilder sb = new StringBuilder();
        sb.append("\n-------正在执行").
                append(traceElement.getClassName()).
                append("::").
                append(traceElement.getMethodName());

        if(isErr){
            System.err.println(sb.toString());
        }else {
            System.out.println(sb.toString());
        }
    }

    /**
     * 自己睡ms毫秒
     * @param ms 毫秒
     */
    public static void sleepSelf(int ms){
        sleepSelf((long)ms);
    }

    public static void sleepSelf(long ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){
//            e.printStackTrace();
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
            if(sum==0){
                System.err.println("hardWork(int times)这不可能吧");
            }else {
                return;
            }
        }
    }
}
