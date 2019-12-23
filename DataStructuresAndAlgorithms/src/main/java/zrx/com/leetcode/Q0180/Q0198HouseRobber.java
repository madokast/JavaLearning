package zrx.com.leetcode.Q0180;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * You are a professional robber planning to rob houses
 * along a street. Each house has a certain amount of
 * money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have
 * security system connected and it will automatically
 * contact the police if two adjacent houses were broken
 * into on the same night.
 *
 * Given a list of non-negative integers representing the
 * amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting
 * the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * Data
 * 2019/12/23 18:26
 *
 * @author zrx
 * @version 1.0
 */

public class Q0198HouseRobber implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build(
                        (Object) MyArrayTools.getIntArray(1,2,3,1),
                        (Object) MyArrayTools.getIntArray(2,7,9,3,1)
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(4,12);
    }

    public class Solution {
        public int rob(int[] nums) {
            //TODO

            return 0;
        }
    }
}
