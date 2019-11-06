package zrx.com.leetcode;

import org.junit.Test;
import zrx.com.leetcode.Q0000.Q0001TwoSum;
import zrx.com.leetcode.utils.MyPrinter;

/**
 * Description
 * Q0000 包测试
 * <p>
 * Data
 * 2019/11/6 10:11
 *
 * @author zrx
 * @version 1.0
 */

public class Q0000Test {
    @Test
    public void testTwoSum(){
        final Q0001TwoSum twoSum = new Q0001TwoSum();
        final int[] ans = twoSum.twoSum(twoSum.inputA01(), twoSum.inputB01());
        MyPrinter.printIntArray(ans,4,true);
    }
}
