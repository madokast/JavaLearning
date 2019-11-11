package zrx.com.leetcode.Q0020;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 *  Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5,
 * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference,
 * which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 我的想法，好问题啊
 *
 * <p>
 * Data
 * 2019/11/10 15:19
 *
 * @author zrx
 * @version 1.0
 */

public class Q0026RemoveDuplicatesFromSortedArray implements Question {
    @Override
    public String getQuestionName() {
        return "Q0026RemoveDuplicatesFromSortedArray";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(1,
                MyArrayTools.getIntArray(1,1,2),
                MyArrayTools.getIntArray(0,0,1,1,1,2,2,3,3,4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class,2,5);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new Solution0026(),"removeDuplicates",int[].class);
    }

    @Override
    public int[] reprintInputs() {
        return new int[]{0};
    }

    public class Solution0026 {
        //Runtime: 1 ms, faster than 97.63% of Java online submissions for Remove Duplicates from Sorted Array.
        //Memory Usage: 41.2 MB, less than 25.53% of Java online submissions for Remove Duplicates from Sorted Array.
        public int removeDuplicates(int[] nums) {
//            System.err.println(MyArrayTools.intArrayToString(nums));
            int i = 0;
            int j = 1;
            for (; j < nums.length; j++) {
                if(nums[j]==nums[i]){
                    //do nothing
                }else {
                    i++;
                    MyArrayTools.swap(nums,i,j);
                }
            }

//            System.err.println(MyArrayTools.intArrayToString(nums));
            return i+1;
        }
    }
}
