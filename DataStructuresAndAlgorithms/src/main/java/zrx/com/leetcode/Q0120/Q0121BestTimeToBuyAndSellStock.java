package zrx.com.leetcode.Q0120;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * Say you have an array for which the ith element is
 * the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one
 * transaction (i.e., buy one and sell one share of the
 * stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day
 * 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than
 * buying price.
 * <p>
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done,
 * i.e. max profit = 0.
 * <p>
 * Data
 * 2019/12/24 14:50
 *
 * @author zrx
 * @version 1.0
 */

public class Q0121BestTimeToBuyAndSellStock implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 1, 5, 3, 6, 4)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(7, 6, 4, 3, 1))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(5, 0);
    }

    public class Solution0121 {
        public int maxProfit(int[] prices) {

            //TODO
            return 0;
        }
    }
}
