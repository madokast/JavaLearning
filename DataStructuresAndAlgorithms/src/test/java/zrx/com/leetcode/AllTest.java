package zrx.com.leetcode;

import org.junit.Test;
import zrx.com.leetcode.Q0020.*;
import zrx.com.leetcode.Q0040.Q0042TrappingRainWater;
import zrx.com.leetcode.UtilsTest.MyArrayAddOneTest;
import zrx.com.leetcode.UtilsTest.MyStringAllIndexOfTest;
import zrx.com.leetcode.utils.LeerCodeTest.QuestionDemo;
import zrx.com.leetcode.utils.LeerCodeTest.TestForLeetCode;

/**
 * Description
 * leetcode 全新测试
 * <p>
 * Data
 * 2019/11/10 16:43
 *
 * @author zrx
 * @version 1.0
 */

public class AllTest {
    @Test
    public void test() {
        TestForLeetCode.happy(new QuestionDemo());
        TestForLeetCode.happy(new Q0026RemoveDuplicatesFromSortedArray());
        TestForLeetCode.happy(new Q0027RemoveElement());
        TestForLeetCode.happy(new Q0028ImplementStrStrBrute());
        TestForLeetCode.happyTimeLimit(new Q0028ImplementStrStrKMP(),2);
        TestForLeetCode.happyTimeLimit(new Q0030SubstringWithConcatenationOfAllWordsBrute(),2);
        TestForLeetCode.happyTimeLimit(new Q0030SubstringWithConcatenationOfAllWordsMap(),5);
        TestForLeetCode.happyTimeLimit(new Q0042TrappingRainWater(),5);

    }

    @Test
    public void utilsTest(){
        TestForLeetCode.happy(new MyStringAllIndexOfTest());
        TestForLeetCode.happy(new MyArrayAddOneTest());
    }
}
