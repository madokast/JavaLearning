package zrx.com.leetcode.Q0620;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;
import java.util.Objects;

/**
 * Description
 * Given an integer array, find three numbers whose
 * product is maximum and output the maximum product.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: 24
 *
 *
 * Note:
 *
 * The length of the given array will be in range
 * [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input
 * won't exceed the range of 32-bit signed integer.
 * <p>
 * Data
 * 2019/12/23 18:20
 *
 * @author zrx
 * @version 1.0
 */

public class Q0628MaximumProductOfThreeNumbers implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1,2,3)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1,2,3,4))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(6,24);
    }

    public class Solution0628 {
        public int maximumProduct(int[] nums) {
            // TODO
            return 0;
        }
    }
}
