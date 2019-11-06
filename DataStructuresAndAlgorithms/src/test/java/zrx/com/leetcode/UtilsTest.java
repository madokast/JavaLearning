package zrx.com.leetcode;

import org.junit.Test;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyPrinter;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyRequire;

/**
 * Description
 * utils 包测试
 * <p>
 * Data
 * 2019/11/6 10:32
 *
 * @author zrx
 * @version 1.0
 */


public class UtilsTest {
    @Test
    public void binarySearchTest() {
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 1));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 2));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 3));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 4));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4), 3));

        System.out.println("-------------");

        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 3));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 4));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 1));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), -1));

    }

    @Test
    public void randomIntArrayTest() {
        final int[] randomIntArray = MyRandom.randomIntArray(3, 5, 10);
        MyPrinter.printIntArray(randomIntArray, 4, true);
    }


    @Test
    public void printIntArrayTest() {
        MyPrinter.printIntArray(new int[]{1, 2, 3}, 4, true);
        MyPrinter.printIntArray(new int[]{1, 2, 3}, 4, false);
    }

}
