package zrx.com.leetcode.Q0160;

import zrx.com.leetcode.utils.MyArrayTools;

/**
 * Description
 * Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, //增序
 * find two numbers such that they add up to MyTools specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers
 * such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * // 返回的为索引+1 即从1排序
 * You may assume that each input would have exactly one solution
 * and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * <p>
 * ----------------------------------------------------------------------------
 * 我的想法：二分查找即可，可能比hash要快。先去写个二分查找算法
 * <p>
 * 数组允许重复值!!
 * <p>
 * 答案：---------------------------------------------------------------------------
 * 典型的双指针问题。
 * 初始化左指针left指向数组起始，初始化右指针right指向数组结尾。
 * <p>
 * 根据已排序这个特性，
 * <p>
 * （1）如果numbers[left]与numbers[right]的和tmp小于target，说明应该增加tmp,因此left右移指向一个较大的值。
 * <p>
 * （2）如果tmp大于target，说明应该减小tmp,因此right左移指向一个较小的值。
 * <p>
 * （3）tmp等于target，则找到，返回left+1和right+1。（注意以1为起始下标）
 * <p>
 * 时间复杂度O(n): 扫一遍
 * <p>
 * 空间复杂度O(1)
 * <p>
 * ps: 严格来说，两个int的加和可能溢出int，因此将tmp和target提升为long long int再进行比较更鲁棒。
 * <p>
 * Data
 * 2019/11/6 11:29
 *
 * @author zrx
 * @version 1.0
 */

public class Q0167TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        return new Solution().twoSum(numbers, target);
    }

    public int[] twoSum2(int[] numbers, int target) {
        return new Solution().twoSum2(numbers, target);
    }



    public static final int[] numbers = {2, 7, 11, 15};
    public static final int target = 9;
    public static final int[] answer = {1, 2};

    //[1,2,3,4,4,9,56,90]
    //8
    //[4,5]
    public static final int[] numbers2 = {1, 2, 3, 4, 4, 9, 56, 90};
    public static final int target2 = 8;
    public static final int[] answer2 = {4, 5};
}

class Solution {
    //    双指针法
    // 没错，双指针是正确的
    // 这里给出证明：因为是i j反别往内走，而且一次只有一个走
    // 那么一定存在一个时刻，i或j走到了答案所指向得位置
    // 比如说 答案是 3/5 那么假设i首先到了3
    // 这时j肯定大于5
    // 这时一定由[i]+[j]>target
    // 所以 j 肯定要变小
    // 然后就是 j 一直走
    // 当然就成了
    // 证明与 2019年11月6日 21点49分
    //Details
    //Runtime: 1 ms, faster than 57.01% of Java online submissions for Two Sum II - Input array is sorted.
    //Memory Usage: 37.8 MB, less than 99.25% of Java online submissions for Two Sum II - Input array is sorted.
    //Next challenges:
    //Two Sum IV - Input is MyTools BST
    //Two Sum Less Than K
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            if((numbers[left]+numbers[right])==target){
                return new int[]{left+1,right+1};
            }else if((numbers[left]+numbers[right])<target){
                left++;
            }else {
                right--;
            }
        }

        return null;
    }

    //二分查找法
    //2019年11月6日
    //Success
    //Details
    //Runtime: 2 ms, faster than 31.24% of Java online submissions for Two Sum II - Input array is sorted.
    //Memory Usage: 38.1 MB, less than 94.03% of Java online submissions for Two Sum II - Input array is sorted.
    //Next challenges:
    //Two Sum IV - Input is MyTools BST
    //Two Sum Less Than K
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int counter = target - numbers[i];
            if (counter < numbers[i]) { // 当 target - numbers[i] 比[i]小时，不用再找了
                return null;
            }
            final int find = MyArrayTools.binarySearch(numbers, counter);
            if (find != -1) {
                //重复值判断
                if (find == i) {
                    //left
                    if (find > 0 && counter == numbers[find - 1]) {
                        return new int[]{i, i + 1};
                    } else if (counter == numbers[find + 1]) {
                        return new int[]{i + 1, i + 2};
                    }
                } else {
                    return new int[]{i + 1, find + 1};
                }
            }
        }

        return null;
    }
}
