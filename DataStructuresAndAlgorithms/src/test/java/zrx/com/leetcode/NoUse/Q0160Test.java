package zrx.com.leetcode.NoUse;

import org.junit.Assert;
import org.junit.Test;
import zrx.com.leetcode.Q0160.Q0167TwoSum2InputArrayIsSorted;
import zrx.com.leetcode.utils.MyPrinter;
import zrx.com.leetcode.utils.MyRequire;

/**
 * Description
 * leetcode 0160 - 0179 测试
 * <p>
 * Data
 * 2019/11/6 11:51
 *
 * @author zrx
 * @version 1.0
 */

public class Q0160Test {
//    @Test
    public void testTwoSum2InputArrayIsSorted2(){
        final Q0167TwoSum2InputArrayIsSorted twoSum2InputArrayIsSorted = new Q0167TwoSum2InputArrayIsSorted();
        final int[] ans = twoSum2InputArrayIsSorted.twoSum(Q0167TwoSum2InputArrayIsSorted.numbers, Q0167TwoSum2InputArrayIsSorted.target);
        MyPrinter.printIntArray(ans);
        Assert.assertTrue(MyRequire.isEqual(ans, Q0167TwoSum2InputArrayIsSorted.answer));

        final int[] ans2 = twoSum2InputArrayIsSorted.twoSum(Q0167TwoSum2InputArrayIsSorted.numbers2, Q0167TwoSum2InputArrayIsSorted.target2);
        MyPrinter.printIntArray(ans2);
        Assert.assertTrue(MyRequire.isEqual(ans2, Q0167TwoSum2InputArrayIsSorted.answer2));
    }

//    @Test
    public void testTwoSum2InputArrayIsSorted(){
        final Q0167TwoSum2InputArrayIsSorted twoSum2InputArrayIsSorted = new Q0167TwoSum2InputArrayIsSorted();
        final int[] ans = twoSum2InputArrayIsSorted.twoSum2(Q0167TwoSum2InputArrayIsSorted.numbers, Q0167TwoSum2InputArrayIsSorted.target);
        MyPrinter.printIntArray(ans);
        Assert.assertTrue(MyRequire.isEqual(ans, Q0167TwoSum2InputArrayIsSorted.answer));

        final int[] ans2 = twoSum2InputArrayIsSorted.twoSum2(Q0167TwoSum2InputArrayIsSorted.numbers2, Q0167TwoSum2InputArrayIsSorted.target2);
        MyPrinter.printIntArray(ans2);
        Assert.assertTrue(MyRequire.isEqual(ans2, Q0167TwoSum2InputArrayIsSorted.answer2));
    }

}
