package zrx.com.leetcode.Q0560;


import zrx.com.leetcode.utils.MyArrayTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * <p>
 * 我的想法：这次总算是滑动窗口法了吧!!
 * 有难度，因为{1，2，3，0，0，0，-100，0，0，0，100}
 * 目标6
 * 那么有很多解的，这怎么找？
 *
 * <p>
 * Data
 * 2019/11/9 10:44
 *
 * @author zrx
 * @version 1.0
 */

public class Q0560SubarraySumEqualsK {
    public static void test() {
        final Solution0560 s = new Solution0560();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(s.subarraySum(new int[]{1}, 0));
        System.out.println(s.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println("---------------------------");
        System.out.println(s.subarraySum0(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum0(new int[]{1, 2, 3}, 3));
        System.out.println(s.subarraySum0(new int[]{1}, 0));
        System.out.println(s.subarraySum0(new int[]{-1, -1, 1}, 0));
        System.out.println("---------------------------");
        System.out.println(s.subarraySum1(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum1(new int[]{1, 2, 3}, 3));
        System.out.println(s.subarraySum1(new int[]{1}, 0));
        System.out.println(s.subarraySum1(new int[]{-1, -1, 1}, 0));
        System.out.println("---------------------------");
    }
}

class Solution0560 {
    //看答案
    public int subarraySum1(int[] nums, int k){
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    //map法
    //Runtime: 19 ms, faster than 32.28% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 38.5 MB, less than 98.91% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum0(int[] nums, int k) {
        int ansNum = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum,new ArrayList<>());
            }

            map.get(sum).add(i);
        }

        ansNum += map.getOrDefault(k, new ArrayList<>()).size();

        sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            final List<Integer> list = map.getOrDefault(sum + k,new ArrayList<>());
            if(list.size()>0){
                ansNum+=MyArrayTools.numberInListBiggerThan(i,list);
            }
        }

        return ansNum;
    }

    //暴力法
    //Runtime: 109 ms, faster than 27.69% of Java online submissions for Subarray Sum Equals K.
    //Memory Usage: 38.8 MB, less than 98.91% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            if (nums[0] == k)
                return 1;
            else
                return 0;
        }

        int ansNum = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k)
                ansNum++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ansNum++;
                }
            }
        }

        return ansNum;
    }
}
