package zrx.com.leetcode.utils;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntConsumer;

/**
 * Description
 * 打印用utils
 * <p>
 * Data
 * 2019/11/6 10:17
 *
 * @author zrx
 * @version 1.0
 */

public class MyPrinter {
    public static void printIntArray(int[] arr, int width,boolean isErr){
        Objects.requireNonNull(arr);
        print("IntArray:[",isErr);
        Arrays.stream(arr).forEach(e->print(wideFormat(e,width),isErr));
        print("]",isErr);
        newline(isErr);
    }

    public static void printIntArray(int[] arr){
        printIntArray(arr,4,false);
    }


    private static String wideFormat(Object data,int width){
        return String.format("%"+width+"s",data);
    }

    /**
     * 辅助打印方法
     * @param data 要打印的数据
     * @param isErr 是否以err打印
     */
    private static void print(Object data,boolean isErr){
        if(isErr){
            System.err.print(data);
        }else {
            System.out.print(data);
        }
    }

    /**
     * 辅助打印方法。换行
     * @param data 要打印的数据
     * @param isErr 是否以err打印
     */
    private static void println(Object data,boolean isErr){
        if(isErr){
            System.err.println(data);
        }else {
            System.out.println(data);
        }
    }

    /**
     * 仅换行
     * @param isErr 是否以err打印
     */
    private static void newline(boolean isErr){
        println("",isErr);
    }
}
