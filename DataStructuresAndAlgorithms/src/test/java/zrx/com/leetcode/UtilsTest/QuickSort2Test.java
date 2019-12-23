package zrx.com.leetcode.UtilsTest;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;

import java.util.Arrays;

/**
 * Description
 * quickSort2
 * <p>
 * Data
 * 2019/12/23 15:45
 *
 * @author zrx
 * @version 1.0
 */

public class QuickSort2Test {
    @Test
    public void test(){
        MyTools.printCurrentMethod(true,"quickSort2Test");
        for (int i = 0; i < 5; i++) {
            final int[] ints = MyRandom.randomIntArray(100, 20 + i);
            System.out.println("原数组" + Arrays.toString(ints));
            MyArrayTools.quickSort2(ints);
            System.out.println("排序后" + Arrays.toString(ints));
            if(MyArrayTools.isSorted(ints)){
                System.out.println("排序正确");
            }else {
                System.err.println("排序错误");
            }
        }
    }
}
