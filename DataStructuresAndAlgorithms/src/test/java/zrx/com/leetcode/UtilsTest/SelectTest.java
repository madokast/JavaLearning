package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyRequire;

import java.util.Arrays;

/**
 * Description
 * select
 * <p>
 * Data
 * 2019/12/17 21:03
 *
 * @author zrx
 * @version 1.0
 */

public class SelectTest {
    @Test
    public void test() {
        MyTools.printCurrentMethod(true, "select test");
        int arrayLength = 20;
        for (int i = 0; i < arrayLength; i++) {
            final int[] ints = MyRandom.randomIntArray(100, arrayLength);
            System.out.println(Arrays.toString(ints));
            final int[] intsCopy = Arrays.copyOf(ints, arrayLength);

            MyRequire.requireTrue(Arrays.equals(ints, intsCopy));

            int k = i + 1;
            System.out.println("k = " + k);

            final int select = MyArrayTools.select(ints, k);
            System.out.println("select = " + select);

            MyArrayTools.quickSort(ints);
            MyArrayTools.quickSort(intsCopy);
            System.out.println(Arrays.toString(ints));

            MyRequire.requireTrue(Arrays.equals(ints, intsCopy));

            MyRequire.requireTrue(select == intsCopy[k - 1]);

            System.out.println("------------------------");
        }
    }
}
