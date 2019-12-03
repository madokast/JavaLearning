package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;

/**
 * Description
 * 工具类小测试
 * <p>
 * Data
 * 2019/12/1 15:03
 *
 * @author zrx
 * @version 1.0
 */

public class SmallTest {
    @Test public void test(){}

    @Test public void testIsSorted(){
        MyTools.printCurrentMethod(true);
        final int[] intArray = MyArrayTools.getIntArray(1, 1, 2, 3, 4, 3, 2);
        System.out.println("Arrays.toString(intArray) = " + Arrays.toString(intArray));
        System.out.println("MyArrayTools.isSorted(intArray) = " + MyArrayTools.isSorted(intArray));
        System.out.println("MyArrayTools.isSorted(intArray,1,5) = " + MyArrayTools.isSorted(intArray, 1, 5));

        System.out.println("MyArrayTools.isAntiSorted(intArray,4,7) = " + MyArrayTools.isAntiSorted(intArray, 4, 7));

    }

    @Test public void testNaturalNumber(){
        MyTools.printCurrentMethod(true);
        final int[] ints = MyArrayTools.naturalNumber(5);
        System.out.println(Arrays.toString(ints));
    }
}
