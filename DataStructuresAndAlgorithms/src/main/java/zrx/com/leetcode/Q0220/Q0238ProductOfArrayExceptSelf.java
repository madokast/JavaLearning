package zrx.com.leetcode.Q0220;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for
 * the purpose of space complexity analysis.)
 *
 * 这道题给定我们一个数组，让我们返回一个新数组，对于每一
 * 个位置上的数是其他位置上数的乘积，并且限定了时间复杂度
 * O(n)，并且不让我们用除法。如果让用除法的话，那这道题就
 * 应该属于 Easy，因为可以先遍历一遍数组求出所有数字之积，
 * 然后除以对应位置的上的数字。但是这道题禁止我们使用除法，
 * 那么我们只能另辟蹊径。我们想，对于某一个数字，如果我们
 * 知道其前面所有数字的乘积，同时也知道后面所有的数乘积，
 * 那么二者相乘就是我们要的结果，所以我们只要分别创建出这两
 * 个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积
 * 累积数组。参见代码如下：
 *
 * 我们可以对上面的方法进行空间上的优化，由于最终的结果都是
 * 要乘到结果 res 中，所以可以不用单独的数组来保存乘积，而是
 * 直接累积到结果 res 中，我们先从前面遍历一遍，将乘积的累积
 * 存入结果 res 中，然后从后面开始遍历，用到一个临时变量 right，
 * 初始化为1，然后每次不断累积，最终得到正确结果，参见代码如下：
 *
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
 * Memory Usage: 42.7 MB, less than 48.03% of Java online submissions for Product of Array Except Self.
 *
 * 喟然叹息：这个解法真的厉害
 * <p>
 * Data
 * 2019/12/23 9:25
 *
 * @author zrx
 * @version 1.0
 */

public class Q0238ProductOfArrayExceptSelf implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(1,2,3,4))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(
                int[].class,(Object)MyArrayTools.getIntArray(24,12,8,6));
    }


    public class Solution0238 {
        public int[] productExceptSelf(int[] nums) {
            int[] ans = new int[nums.length];

            //第一个数为1
            ans[0] = 1;

            //ans = 1 1 2 6
            for (int i = 1 ; i < nums.length; i++) {
                ans[i] = ans[i-1] * nums[i-1];
            }

            int right = nums[nums.length-1];
            for (int i = nums.length-2; i >=0 ; i--) {
                ans[i] *= right;
                right*=nums[i];
            }

            return ans;
        }
    }
}
