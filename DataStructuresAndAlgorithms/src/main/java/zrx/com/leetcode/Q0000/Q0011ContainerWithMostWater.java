package zrx.com.leetcode.Q0000;

/**
 * Description
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that
 * the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * <p>
 * 我的想法：看了解答思路，是双指针问题
 * <p>
 * Data
 * 2019/11/10 13:42
 *
 * @author zrx
 * @version 1.0
 */

public class Q0011ContainerWithMostWater {
    public static void test() {
        System.err.println("Q0011ContainerWithMostWater");
        final Solution0011 s = new Solution0011();
        System.out.println(s.maxArea(in01));
    }

    private static final int[] in01 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    private static final int ans = 49;
}

class Solution0011 {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Container With Most Water.
    //Memory Usage: 40.1 MB, less than 93.59% of Java online submissions for Container With Most Water.
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = area(height, left, right);

        while (left < right) {
            if (height[left] <= height[right]) {
                //left这边短了
                int left0Hight = height[left];
                while (left < right) {
                    left++;
                    if (height[left] > left0Hight) {
                        break;
                    }
                }
            } else {
                int right0Height = height[right];
                while (left < right) {
                    right--;
                    if (height[right] > right0Height) {
                        break;
                    }
                }
            }
            maxArea = Math.max(maxArea, area(height, left, right));
        }
        return maxArea;
    }

    private int area(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}

