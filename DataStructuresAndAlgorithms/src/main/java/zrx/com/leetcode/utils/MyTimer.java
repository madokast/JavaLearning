package zrx.com.leetcode.utils;

/**
 * Description
 * 计时器
 * <p>
 * Data
 * 2019/11/8 21:54
 *
 * @author zrx
 * @version 1.0
 */

public class MyTimer {
    private static boolean isOddCall = false;
    private static long start;
    public static void runtime(){
        if(isOddCall){
            long end = System.currentTimeMillis();
            System.err.println("run "+(((double)(end-start))/1000)+"s");
            isOddCall = false;
        }else {
            start = System.currentTimeMillis();
            isOddCall = true;
        }
    }
}
