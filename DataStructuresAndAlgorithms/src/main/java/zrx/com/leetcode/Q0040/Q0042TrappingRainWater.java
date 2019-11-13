package zrx.com.leetcode.Q0040;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.LeerCodeTest.TestEntry;

import java.util.List;

/**
 * Description
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation
 * map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * 有更好的的方法
 * int trap(vector<int>& height)
 * {
 *     int left = 0, right = height.size() - 1;
 *     int ans = 0;
 *     int left_max = 0, right_max = 0;
 *     while (left < right) {
 *         if (height[left] < height[right]) {
 *             height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
 *             ++left;
 *         }
 *         else {
 *             height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
 *             --right;
 *         }
 *     }
 *     return ans;
 * }
 *
 * <p>
 * Data
 * 2019/11/11 22:04
 *
 * @author zrx
 * @version 1.0
 */

public class Q0042TrappingRainWater implements Question {
    @Override
    public String getQuestionName() {
        return "Q0042TrappingRainWater";
    }

    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputsList(1,
                (Object) new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
                (Object) new int[]{2,0,2},
                (Object) new int[]{4,2,3}
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(int.class,6,2,1);
    }

    @Override
    public TestEntry getTestEntry() {
        return TestEntry.getInstance(Solution0042.class);
    }

    public class Solution0042 {
        //Runtime: 1 ms, faster than 97.87% of Java online submissions for Trapping Rain Water.
        //Memory Usage: 37.3 MB, less than 98.63% of Java online submissions for Trapping Rain Water.
        public int trap(int[] height) {
            int left = 0;
            int right = height.length-1;
            int currentMaxHeight = 0;
            int previousMaxHeight = 0;
            int value = 0;

            while (left<right){
                while (left<right&&height[left]<=currentMaxHeight){
                    left++;
                }
                while (left<right&&height[right]<=currentMaxHeight){
                    right--;
                }

                currentMaxHeight = Math.max(currentMaxHeight,
                        Math.min(height[left],height[right]));

                for (int i = left + 1 ; i <right ; i++) {
                    if(height[i]<currentMaxHeight){
                        value+=currentMaxHeight - Math.max(height[i],previousMaxHeight);
                    }
                }

                previousMaxHeight = currentMaxHeight;
            }


            return value;
        }
    }
}
