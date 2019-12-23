package zrx.com.leetcode.Q0040;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * Given an integer array nums, find the contiguous
 * subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try
 * coding another solution using the divide and
 * conquer approach, which is more subtle.
 * <p>
 * Data
 * 2019/12/23 18:23
 *
 * @author zrx
 * @version 1.0
 */

public class Q0053MaximumSubarray implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(-2,1,-3,4,-1,2,1,-5,4))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(6);
    }

    public class Solution {
        public int maxSubArray(int[] nums) {
            //TODO
            return 0;
        }
    }
}
