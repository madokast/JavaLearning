package zrx.com.leetcode.utils;


/**
 * Description
 * 需求类，不满足抛出异常
 * <p>
 * Data
 * 2019/11/6 10:48
 *
 * @author zrx
 * @version 1.0
 */

public class MyRequire {
    public static void throwRunTimeException(String msg){
        throw new RuntimeException(msg);
    }

    /**
     * MyTools!=b时，抛出异常
     * @param a 数1
     * @param b 数2
     */
    public static void equal(int a, int b){
        if(a!=b){
            throw new RuntimeException(a+"!="+b);
        }
    }

    /**
     * int[]是否是递增
     * @param arr 数组
     */
    public static boolean isOrdered(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]>arr[i])
                return false;
        }
        return true;
    }

    /**
     * 判断两个int[] 是否长度一致，元素相同
     * 不会抛出异常
     * @param a 数组一
     * @param b 数组二
     * @return 是否一致
     */
    public static boolean isEqual(int[] a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public static void greaterThanZero(int num) {
        if (num <= 0) {
            throw new RuntimeException(num + "<=0");
        }

    }

    public static void greater(int smaller, int bigger) {
        if (bigger <= smaller) {
            throw new RuntimeException(smaller + ">=" + bigger);
        }
    }


    public static void requireTrue(boolean b){
        if(!b)
            throw new RuntimeException("requireTrue failed");
    }
}
