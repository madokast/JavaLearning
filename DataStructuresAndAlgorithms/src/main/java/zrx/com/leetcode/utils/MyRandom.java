package zrx.com.leetcode.utils;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Description
 * 随机类
 * <p>
 * Data
 * 2019/11/6 10:17
 *
 * @author zrx
 * @version 1.0
 */

public class MyRandom {
    private static Random random = new Random();

    public static int[] randomIntArray(int smallest, int biggest, int length) {
        MyRequire.greaterThanZero(length);
        final int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nextInt(smallest, biggest);
        }
        return arr;
    }

    public static int[] randomIntArray(int biggest, int length) {
        return randomIntArray(0, biggest, length);
    }

    public static int nextInt(int smallest, int biggest) {
        MyRequire.greater(smallest, biggest);
        return random.nextInt(biggest - smallest + 1) + smallest;
    }

    public static int nextInt(int biggest) {
        MyRequire.greaterThanZero(biggest);
        return nextInt(0, biggest);
    }
}
