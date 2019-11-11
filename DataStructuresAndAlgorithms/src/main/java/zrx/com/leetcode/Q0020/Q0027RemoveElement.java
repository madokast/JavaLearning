package zrx.com.leetcode.Q0020;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * Remove Element
 * Given an array nums and a value val,
 * remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference,
 * which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 我的想法：怎么才能移动次数最少呢？
 *
 * <p>
 * Data
 * 2019/11/10 21:01
 *
 * @author zrx
 * @version 1.0
 */

public class Q0027RemoveElement implements Question {
    @Override
    public String getQuestionName() {
        return "Q0027RemoveElement";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(2,
                new int[]{3,2,2,3},3,
                new int[]{0,1,2,2,3,0,4,2},2,
                new int[]{3,3},3,
                new int[]{4,5},5
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class,2,5,0,1);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(new Solution0027(),"removeElement",int[].class,int.class);
    }

    @Override
    public int[] reprintInputs() {
        return new int[]{0};
    }

    public class Solution0027 {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
        //Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Element.
        public int removeElement(int[] nums, int val) {
            if(nums.length==0){
                return 0;
            }
            if (nums.length == 1) {
                if (nums[0] == val) {
                    return 0;
                } else {
                    return 1;
                }
            }


            int left = 0;
            int right = nums.length - 1;

            while (right >= left) {
                if (nums[left] == val) {
                    while (right > left && nums[right] == val) {
                        right--;
                    }
                    if (right > left) {
                        MyArrayTools.swap(nums, left, right);
                        right--;
                    }
                }
                left++;
            }

            if(nums[right]==val){
                left--;
            }

            return left;

        }
    }

}

