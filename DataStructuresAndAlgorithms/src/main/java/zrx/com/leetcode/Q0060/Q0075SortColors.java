package zrx.com.leetcode.Q0060;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * <p>
 * 75. Sort Colors
 * <p>
 * 计数排序法
 * <p>
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function
 * for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm
 * using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * <p>
 * Data
 * <p>
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
 * Memory Usage: 35 MB, less than 100.00% of Java online submissions for Sort Colors.
 * <p>
 * 这个有一步法
 *
 * Runtime: 1 ms, faster than 6.84% of Java online submissions for Sort Colors.
 * Memory Usage: 35.2 MB, less than 99.21% of Java online submissions for Sort Colors.
 *
 * public void sortColors(int[] nums) {
 * // 1-pass
 * int p1 = 0, p2 = nums.length - 1, index = 0;
 * while (index <= p2) {
 * if (nums[index] == 0) {
 * nums[index] = nums[p1];
 * nums[p1] = 0;
 * p1++;
 * }
 * if (nums[index] == 2) {
 * nums[index] = nums[p2];
 * nums[p2] = 2;
 * p2--;
 * index--;
 * }
 * index++;
 * }
 * }
 * <p>
 * 2019/12/23 11:15
 *
 * @author zrx
 * @version 1.0
 */

public class Q0075SortColors implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2, 0, 2, 1, 1, 0))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList((Object) MyArrayTools.getIntArray(0, 0, 1, 1, 2, 2));
    }

    public class Solution0075 {
        //数组划分法
        public int[] sortColors(int[] nums) {
            int p0 = 0;
            int p1 = 0;
            int p2 = nums.length - 1;

            while (p1 <= p2) {
                switch (nums[p1]){
                    case 0:
                        if(p0==p1){
                            p0++;
                            p1++;
                        }else {
                            MyArrayTools.swap(nums,p1,p0);
                            p0++;
                        }
                        break;
                    case 1:
                        p1++;
                        break;
                    case 2:
                        MyArrayTools.swap(nums,p1,p2);
                        p2--;
                        break;
                }
            }

            return nums;
        }

        //计数排序法
        private int[] sortColors2(int[] nums) {
            int zero = 0;
            int one = 0;
            int two = 0;

            for (int i : nums) {
                switch (i) {
                    case 0:
                        zero++;
                        break;
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                }
            }

            int i = 0;

            for (int j = 0; j < zero; j++) {
                nums[i] = 0;
                i++;
            }

            for (int j = 0; j < one; j++) {
                nums[i] = 1;
                i++;
            }

            for (int j = 0; j < two; j++) {
                nums[i] = 2;
                i++;
            }

            return nums;
        }


    }
}
