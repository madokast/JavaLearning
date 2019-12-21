package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyRequire;

import java.util.Arrays;

/**
 * Description
 * partition test
 * <p>
 * Data
 * 2019/12/17 20:23
 *
 * @author zrx
 * @version 1.0
 */

public class PartitionTest {
    @Test
    public void test01(){
        MyTools.printCurrentMethod(true,"测试Partition");
        int arrayLength = 20;
        for (int i = 0; i < arrayLength; i++) {
            final int[] ints = MyRandom.randomIntArray(100, arrayLength);
            System.out.println(Arrays.toString(ints));
            int pivot = ints[i];
            final int newPointOfPivot = MyArrayTools.partition(ints, 0, arrayLength - 1, i);
            System.out.println(Arrays.toString(ints));
            MyRequire.requireTrue(pivot == ints[newPointOfPivot]);

            for (int j = 0; j < newPointOfPivot; j++) {
                MyRequire.requireTrue(ints[j]<pivot);
            }

            for (int j = newPointOfPivot + 1; j < arrayLength; j++) {
                MyRequire.requireTrue(ints[j]>=pivot);
            }

            System.out.println("------------------------");
        }

        System.out.println("测试通过");
    }


}
