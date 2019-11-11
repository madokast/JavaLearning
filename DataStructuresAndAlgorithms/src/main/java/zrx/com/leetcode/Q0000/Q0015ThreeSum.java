package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyPrinter;
import zrx.com.leetcode.utils.MyRequire;

import javax.print.attribute.standard.NumberUp;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

/**
 * Description
 * 15. 3Sum
 * Given an array nums of n integers,
 * are there elements MyTools, b, c in nums such that MyTools + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * Data
 * 2019/11/6 12:30
 *
 * @author zrx
 * @version 1.0
 */

public class Q0015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return new Solution0015().threeSum(nums);
    }

    public List<List<Integer>> threeSum0(int[] nums) {
        return new Solution0015().threeSum0(nums);
    }

    public static final int[] input = {-1, 0, 1, 2, -1, -4};
    public static final List<List<Integer>> ans = new ArrayList<>(2);

    static {
        ans.add(MyArrayTools.intArrayToList(MyArrayTools.getIntArray(-1, 0, 1)));
        ans.add(MyArrayTools.intArrayToList(MyArrayTools.getIntArray(-1, -1, 2)));
    }
}

class Solution0015 {

//Runtime: 35 ms, faster than 50.01% of Java online submissions for 3Sum.
//Memory Usage: 46.6 MB, less than 91.87% of Java online submissions for 3Sum.
    //三指针法。正统
    public List<List<Integer>> threeSum(int[] nums) {
        System.err.println("三指针法。正统");
        List<List<Integer>> ansList = new ArrayList<>();

        //首先要排序。这时双指针、三指针的必须
        MyArrayTools.quickSort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //这个跳过好啊
            if(i!=0&&nums[i]==nums[i-1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    final List<Integer> maybeAns = MyArrayTools.intArrayToList(
                            MyArrayTools.getIntArray(nums[i], nums[j], nums[k]));

//                    boolean alreadyHave = false;
//                    for (List<Integer> ans : ansList) {
//                        if(MyRequire.isEqual(MyArrayTools.listToIntArray(ans),
//                                MyArrayTools.listToIntArray(maybeAns)))
//                            alreadyHave=true;
//                    }
//
//                    if(!alreadyHave){
//                        ansList.add(maybeAns);
//                    }

                    ansList.add(maybeAns);

                    //神来之笔
                    j++;
                    k--;

                    //然后还可以跳
                    while (j<k&&nums[j]==nums[j-1])
                        j++;
                    while (k>j&&nums[k]==nums[k+1])
                        k--;
                }

            }
        }
        return ansList;
    }

    //hash map法
    public List<List<Integer>> threeSum0(int[] nums) {
        System.err.println("hash map法");
        List<List<Integer>> ansList = new ArrayList<>();
        List<int[]> ansArray = new ArrayList<>();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                final HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(nums[i], set);
            }
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int counter = -(nums[i] + nums[j]);
                if (map.containsKey(counter)) {
                    final Set<Integer> set = map.get(counter);
                    final Iterator<Integer> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        final Integer k = iterator.next();
                        if (k == i || k == j) {
                            continue;
                        }
                        int[] ans = MyArrayTools.getIntArray(nums[i], nums[j], nums[k]);
                        MyArrayTools.quickSort(ans);
//                        MyPrinter.printIntArray(ans);

                        boolean alreadHave = false;
                        for (int[] ints : ansArray) {
                            if (MyRequire.isEqual(ints, ans))
                                alreadHave = true;
                        }

                        if (!alreadHave) {
                            ansArray.add(ans);
                            ansList.add(MyArrayTools.intArrayToList(ans));
                        }
                    }
                }
            }
        }


        return ansList;
    }
}

//[0,0,0,0]测试不通过