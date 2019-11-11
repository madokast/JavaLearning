package zrx.com.leetcode.Q0000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * leetcode第一个问题
 * Given an array of integers,
 * return indices of the two numbers
 * such that they add up to MyTools specific target.
 * You may assume that each input would have
 * exactly one solution, and you may not use
 * the same element twice.
 * 解法：One-pass Hash Table
 * 定义一个Map<Integer, Integer> map存放(值,索引) 遍历数组，若 target-arr[i] in map ，极为找到
 * 否则存入map
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

public class Q0001TwoSum {
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
        return 9;
    }


}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int counterpart = target - nums[i];
            if(map.containsKey(counterpart)){
                return new int[]{map.get(counterpart), i};
            }else {
                map.put(nums[i],i);
            }
        }

        return null;
    }
}

//Details
//Runtime: 2 ms, faster than 98.96% of Java online submissions for Two Sum.
//Memory Usage: 38.3 MB, less than 78.35% of Java online submissions for Two Sum.