package zrx.com.leetcode.Q0000;

/**
 * Description
 * leetcode第一个问题
 * Given an array of integers,
 * return indices of the two numbers
 * such that they add up to a specific target.
 * You may assume that each input would have
 * exactly one solution, and you may not use
 * the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * Data
 * 2019/11/6 10:10
 *
 * @author zrx
 * @version 1.0
 */

public class TwoSum {
    /**
     * entry from outer
     * @param nums arr
     * @param target sum as target
     * @return indices of the two numbers
     */
    public int[] twoSum(int[] nums, int target) {
        return new Solution().twoSum(nums,target);
    }

    /**
     * 测试数据 输入一 第一组
     * @return 数组
     */
    public int[] inputA01(){
        return new int[]{2, 7, 11, 15};
    }

    /**
     * 测试数据 输入二 第一组
     * @return 目标
     */
    public int inputB01(){
        return 8;
    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    }
}
