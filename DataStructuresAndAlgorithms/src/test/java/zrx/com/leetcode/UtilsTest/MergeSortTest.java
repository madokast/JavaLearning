package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;

import java.util.Arrays;

/**
 * Description
 * mergeSort
 * <p>
 * Data
 * 2019/12/22 22:47
 *
 * @author zrx
 * @version 1.0
 */

public class MergeSortTest {
    @Test
    public void test(){
        MyTools.printCurrentMethod(true,"归并排序测试");
        for (int i = 0; i < 5; i++) {
            final int[] ints = MyRandom.randomIntArray(100, 30+i);
            System.out.println("原数组:" + Arrays.toString(ints));

            MyArrayTools.mergeSort(ints);

            System.out.println("排序后:" + Arrays.toString(ints));

            final boolean sorted = MyArrayTools.isSorted(ints);
            if(sorted){
                System.out.println("排序成功");
            }else {
                System.err.println("排序失败");
            }

            System.out.println("-----------------------");
        }
    }
}
