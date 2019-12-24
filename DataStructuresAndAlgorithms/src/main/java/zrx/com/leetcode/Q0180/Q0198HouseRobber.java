package zrx.com.leetcode.Q0180;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
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
 * <p>
 * Given a list of non-negative integers representing the
 * amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting
 * the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * Data
 * 2019/12/23 18:26
 *
 * //Runtime: 22 ms, faster than 5.71% of Java online submissions for House Robber.
 * Memory Usage: 37.1 MB, less than 5.26% of Java online submissions for House Robber.
 *
 * 我居然搞出来了
 * 我用的是 减治 + 动态规划
 * 对[a b c d e] 经行偷窃，最大收益等于：
 *  max{
 *      a + e + max{[c]},
 *      a + max{[c d]},
 *      e + max{[b c]},
 *      max{[b c d]}
 *  }
 *  同时利用动态规划，存储中间结果
 *
 * ----------------------------
 * 理所当然这不是好方法
 * 查看网友的方法：
 *
 * public int rob(int[] num) {
 *     int[][] dp = new int[num.length + 1][2];
 *     for (int i = 1; i <= num.length; i++) {
 *         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
 *         dp[i][1] = num[i - 1] + dp[i - 1][0];
 *     }
 *     return Math.max(dp[num.length][0], dp[num.length][1]);
 * }
 * dp[i][1] means we rob the current house and dp[i][0] means we don't,
 *
 * so it is easy to convert this to O(1) space
 *
 * public int rob(int[] num) {
 *     int prevNo = 0;
 *     int prevYes = 0;
 *     for (int n : num) {
 *         int temp = prevNo;
 *         prevNo = Math.max(prevNo, prevYes);
 *         prevYes = n + temp;
 *     }
 *     return Math.max(prevNo, prevYes);
 * }
 *
 * ---------------------------------------
 * For all those who are looking for explanation for this problem, here is my code with comments. Same logic.
 *
 * public static int rob(int[] nums)
 *        {
 * 	    int ifRobbedPrevious = 0; 	// max monney can get if rob current house
 * 	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
 *
 * 	    // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
 * 	    for(int i=0; i < nums.length; i++)
 *        {
 * 	    	// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
 * 	        int currRobbed = ifDidntRobPrevious + nums[i];
 *
 * 	        // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
 * 	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);
 *
 * 	        // Update values for the next round
 * 	        ifDidntRobPrevious  = currNotRobbed;
 * 	        ifRobbedPrevious = currRobbed;
 *        }
 *
 * 	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
 *    }
 *
 * @author zrx
 * @version 1.0
 */

public class Q0198HouseRobber implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1, 2, 3, 1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2, 7, 9, 3, 1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2, 1, 1, 2)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(
                        183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211
                ))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(4, 12, 4, 3365);
    }

    public class Solution0198 {

        //最优解，动态规划
        public int rob(int[] nums){
            System.out.println("动态规划最优解法啊啊");
            int preRobSum = 0;
            int preUnRobSum = 0;

            for (int num : nums) {
                int robSum = preUnRobSum+num;
                int unRobSum = Math.max(preRobSum,preUnRobSum);

                preRobSum = robSum;
                preUnRobSum = unRobSum;
            }

            return Math.max(preRobSum,preUnRobSum);


        }

        private int[][][][] data;


        //分支法
        private int rob2(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            data = new int[nums.length][nums.length][2][2];
            {
                for (int i = 0; i < data.length; i++) {
                    for (int i1 = 0; i1 < data[i].length; i1++) {
                        for (int i2 = 0; i2 < data[i][i1].length; i2++) {
                            for (int i3 = 0; i3 < data[i][i1][i2].length; i3++) {
                                data[i][i1][i2][i3] = -1;
                            }
                        }
                    }
                }
            }

            return MyArrayTools.max(
                    rob(nums, 0, true, nums.length - 1, true) + nums[0] + nums[nums.length - 1],
                    rob(nums, 0, false, nums.length - 1, true) + nums[nums.length - 1],
                    rob(nums, 0, true, nums.length - 1, false) + nums[0],
                    rob(nums, 0, false, nums.length - 1, false)
            );
        }

        /**
         * nums[start] 和 nums[end] 的价值已计算
         * 问 (start, end) 内最大可以获得的价值
         *
         * @param nums     数组
         * @param start    开始包括，但是价值额外计算
         * @param robStart start是否偷取
         * @param end      结尾包括，但是价值额外计算
         * @param robEnd   end是否偷取
         * @return 问 (start, end) 内最大可以获得的价值
         */
        private int rob(int[] nums, int start, boolean robStart, int end, boolean robEnd) {
            if (data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] != -1) {
//                System.out.println("data[" + start + "][" + end + "][" + (robStart ? 1 : 0) + "][" + (robEnd ? 1 : 0) + "] = " + data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0]);
                return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0];
            }

            int num = end - start + 1;

            if (num == 2) {
                return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = 0;
            } else if (num == 3) {
                if (robStart == false && robEnd == false) {
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = nums[start + 1];
                } else {
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = 0;
                }
            } else if (num == 4) {
                if (robStart == true && robEnd == true)
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = 0;
                else if (robStart == true && robEnd == false)
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = nums[end - 1];
                else if (robStart == false && robEnd == true)
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = nums[start + 1];
                else
                    return data[start][end][robStart ? 1 : 0][robEnd ? 1 : 0] = Math.max(nums[end - 1], nums[start + 1]);
            } else {
                if (robStart == true && robEnd == true) {
                    return data[start + 1][end - 1][0][0] = rob(nums, start + 1, false, end - 1, false);
                } else if (robStart == true && robEnd == false) {
                    return MyArrayTools.max(
                            (data[start + 1][end - 1][0][1] = rob(nums, start + 1, false, end - 1, true)) + nums[end - 1],
                            data[start + 1][end - 1][0][0] = rob(nums, start + 1, false, end - 1, false)
                    );
                } else if (robStart == false && robEnd == true) {
                    return MyArrayTools.max(
                            (data[start + 1][end - 1][1][0] = rob(nums, start + 1, true, end - 1, false)) + nums[start + 1],
                            data[start + 1][end - 1][0][0] = rob(nums, start + 1, false, end - 1, false)
                    );
                } else {
                    return MyArrayTools.max(
                            data[start + 1][end - 1][0][0] = rob(nums, start + 1, false, end - 1, false),
                            (data[start + 1][end - 1][1][0] = rob(nums, start + 1, true, end - 1, false)) + nums[start + 1],
                            (data[start + 1][end - 1][0][1] = rob(nums, start + 1, false, end - 1, true)) + nums[end - 1],
                            (data[start + 1][end - 1][1][1] = rob(nums, start + 1, true, end - 1, true)) + nums[start + 1] + nums[end - 1]
                    );
                }
            }


        }

        /**
         * 错误解法
         * 不是简单的奇数偶数和的问题
         *
         * @param nums 输入
         * @return 错误
         */
        private int rob1(int[] nums) {
            int oddSum = 0; // 奇书
            int evenSum = 0; // 偶数
            boolean odd = true;

            for (int i = 0; i < nums.length; i++) {
                if (odd) {
                    oddSum += nums[i];
                    odd = false;
                } else {
                    evenSum += nums[i];
                    odd = true;
                }
            }

            return Math.max(evenSum, oddSum);
        }
    }
}
