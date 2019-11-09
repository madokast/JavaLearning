package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.MyArrayTools;

/**
 * Description
 * 3Sum Closest
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input
 * would have exactly one solution.
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * 我的想法：
 * 排序，然后三窗口滑动即可？
 * ——2019年11月8日
 * <p>
 * Data
 * 2019/11/8 22:18
 *
 * @author zrx
 * @version 1.0
 */

public class Q0016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        return new Solution0016().threeSumClosest(nums, target);
    }

    public int threeSumClosest1(int[] nums, int target) {
        return new Solution0016().threeSumClosest1(nums, target);
    }

    public static final int[] in01 = new int[]{-1, 2, 1, -4};
    public static final int in02 = 1;
    public static final int ans01 = 2;

    public static final int[] in011 = new int[]{0, 0, 0};
    public static final int in021 = 1;
    public static final int ans011 = 0;

    public static final int[] in012 = new int[]{0, 2, 2, -3};
    public static final int in022 = 3;
    public static final int ans012 = 4;

}

class Solution0016 {
    //优化
    //Runtime: 8 ms, faster than 15.18% of Java online submissions for 3Sum Closest.
    //Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for 3Sum Closest.
    public int threeSumClosest1(int[] nums, int target) {
        //sort
        MyArrayTools.quickSort(nums);

        int closeSum = nums[0]+nums[1]+nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];

            int currentClose  = nums[i+1]+nums[i+2];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                while (left < right && (nums[left] + nums[right]) < newTarget) {
                    if(Math.abs(nums[left] + nums[right] - newTarget)<Math.abs(currentClose-newTarget)){
                        currentClose = nums[left] + nums[right];
                    }
                    left++;
                }
                while (left < right && (nums[left] + nums[right]) > newTarget) {
                    if(Math.abs(nums[left] + nums[right] - newTarget)<Math.abs(currentClose-newTarget)){
                        currentClose = nums[left] + nums[right];
                    }
                    right--;
                }
                if (left < right && (nums[left] + nums[right]) == newTarget) {
                    return target;
                }
            }

            if(Math.abs(currentClose - newTarget)<Math.abs(closeSum-target)){
                closeSum = currentClose + nums[i];
            }
        }

        return closeSum;
    }


    //Runtime: 7 ms, faster than 21.01% of Java online submissions for 3Sum Closest.
    //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for 3Sum Closest.
    //Next challenges:
    //2019年11月9日 三指针法
    public int threeSumClosest(int[] nums, int target) {
        //sort
        MyArrayTools.quickSort(nums);

        int smaller = Integer.MIN_VALUE;
        int bigger = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];

            int currentSmaller = Integer.MIN_VALUE;
            int currentBigger = Integer.MAX_VALUE;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if((nums[left] + nums[right]) < newTarget){
                    currentSmaller = Math.max(currentSmaller, nums[left] + nums[right]);
                }else {
                    currentBigger = Math.min(currentBigger, nums[left] + nums[right]);
                }

                while (left < right && (nums[left] + nums[right]) < newTarget) {
                    currentSmaller = Math.max(currentSmaller, nums[left] + nums[right]);
                    left++;
                }
                while (left < right && (nums[left] + nums[right]) > newTarget) {
                    currentBigger = Math.min(currentBigger, nums[left] + nums[right]);
                    right--;
                }
                if (left < right && (nums[left] + nums[right]) == newTarget) {
                    return target;
                }
            }

            smaller = Math.max(smaller, currentSmaller + nums[i]);
            bigger = Math.min(bigger, currentBigger + nums[i]);
        }

        if (Math.abs((long)smaller - (long)target) > Math.abs(((long)bigger-(long)target))) {
            return bigger;
        } else {
            return smaller;
        }
    }

    //滑动窗口法不行
    private int threeSumClosest9(int[] nums, int target) {
        //排序
        MyArrayTools.quickSort(nums);

        //这个问题很难啊。我需要一个办法，依次吧sum(3)的递增序列弄出来
        //比如说我有一个序列
        //任取三个数，求和
        //最多有3Cn种
        //我现在需要他们的一个有序排列
        //或者能让我动态的一个个知道这个排列
        //我知道了，逐个移动法


        //去0 不能去0
//        List<Integer> temp = new ArrayList<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]!=0){
//                temp.add(nums[i]);
//            }
//        }
//        nums = MyArrayTools.listToIntArray(temp);
//        if(nums.length<=3){
//            return MyArrayTools.sum(nums);
//        }


        //最前面的三个求和，这是最小值
        int currentSumSmall = nums[0] + nums[1] + nums[2];
        //只有三个树。或者最小值也大了，输出
        if (nums.length == 3 || currentSumSmall >= target)
            return currentSumSmall;

        //下面开始滑动窗口

        //这个用来存放第一次sum>目标的情况
        int currentSumBig = currentSumSmall;

//2019年11月8日 作废
//        for (int i = 3; i < nums.length; i++) {
//            currentSumBig = currentSumBig -nums[i-3] + nums[i];
//            if(currentSumBig>=target){
//                break;
//            }else {
//                currentSumSmall=currentSumBig;
//            }
//        }

        //逐个移动法
        int i = 0;
        int j = 1;
        int k = 2;
        while (i < nums.length && j < nums.length && k < nums.length) {
            //


            currentSumBig = MyArrayTools.sum(i, j, k);
        }


        if (Math.abs(currentSumSmall - target) > Math.abs(currentSumBig - target)) {
            return currentSumBig;
        } else {
            return currentSumSmall;
        }

    }
}
