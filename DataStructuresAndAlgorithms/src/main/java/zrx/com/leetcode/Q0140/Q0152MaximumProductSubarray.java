package zrx.com.leetcode.Q0140;

import zrx.com.leetcode.utils.LeerCodeTest.Answer;
import zrx.com.leetcode.utils.LeerCodeTest.Input;
import zrx.com.leetcode.utils.LeerCodeTest.Question;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.List;

/**
 * Description
 * Given an integer array nums, find the contiguous
 * subarray within an array (containing at least one
 * number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because
 * [-2,-1] is not a subarray.
 * <p>
 * <p>
 * Runtime: 1 ms, faster than 98.10% of Java online submissions for Maximum Product Subarray.
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Maximum Product Subarray.
 *
 * 喟然叹曰：
 *  没想到有这么神奇的算法
 *
 * <p>
 * Data
 * 2019/12/23 11:31
 *
 * @author zrx
 * @version 1.0
 */

public class Q0152MaximumProductSubarray implements Question {
    @Override
    public List<Input[]> getInputsList() {
        return Input.makeInputSet(
                Input.InputSet.build((Object) MyArrayTools.getIntArray(2, 3, -2, 4)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(-2, 0, -1)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(-2, -3, 7)),
                Input.InputSet.build((Object) MyArrayTools.getIntArray(-4, -3, -2))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return Answer.makeAnswerList(6, 0, 42, 12);
    }

    public class Solution0152 {
        //Runtime: 3 ms, faster than 11.89% of Java online submissions for Maximum Product Subarray.
        //Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Maximum Product Subarray.
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int imax = nums[0];
            int imin = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];

                int tmax = max(imax * num, imin * num, num);
                int tmin = min(imax * num, imin * num, num);

                imax = tmax;
                imin = tmin;

//                System.out.println("imax = " + imax);
//                System.out.println("imin = " + imin);

                max = max(max, imax);
            }

            return max;
        }

        private int max(int... ints) {
            int max = ints[0];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] > max) {
                    max = ints[i];
                }
            }

            return max;
        }

        private int min(int... ints) {
            int min = ints[0];
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] < min) {
                    min = ints[i];
                }
            }

            return min;
        }


        //应该就是滑动窗口法了
        private int maxProduct2(int[] nums) {
            int wholeMaxProduct = nums[0];
            int localMaxPositiveProduct = -1;
            int localMaxNegativeProduct = 1;
            int firstNegativeNumberProduct = 1;
            int firstNegativeNumberPoint = -1;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num > 0) {
                    if (localMaxPositiveProduct > 0) {
                        localMaxPositiveProduct *= num;
                    } else {
                        localMaxPositiveProduct = num;
                    }

                    if (wholeMaxProduct < localMaxPositiveProduct) {
                        wholeMaxProduct = localMaxPositiveProduct;
                    }

                    if (firstNegativeNumberProduct > 0) {
                        firstNegativeNumberProduct *= num;
                    }

                    localMaxNegativeProduct *= num;

                    if (localMaxNegativeProduct > wholeMaxProduct) {
                        wholeMaxProduct = localMaxNegativeProduct;
                    }

                    if (firstNegativeNumberProduct < 0 && localMaxNegativeProduct < 0) {
                        int t = localMaxNegativeProduct / firstNegativeNumberProduct;
                        if (t > wholeMaxProduct) {
                            wholeMaxProduct = t;
                        }
                    }


                } else if (num < 0) {
                    localMaxPositiveProduct = -1;

                    if (firstNegativeNumberProduct > 0) {
                        firstNegativeNumberPoint = i;
                        firstNegativeNumberProduct *= num; //negative
                    }

                    localMaxNegativeProduct *= num;

                    if (localMaxNegativeProduct > wholeMaxProduct) {
                        wholeMaxProduct = localMaxNegativeProduct;
                    }

                    if (firstNegativeNumberProduct < 0 && localMaxNegativeProduct < 0 && firstNegativeNumberPoint != i) {
                        int t = localMaxNegativeProduct / firstNegativeNumberProduct;
                        if (t > wholeMaxProduct) {
                            wholeMaxProduct = t;
                        }
                    }


                } else {
                    //num == 0

                    firstNegativeNumberProduct = 1;
                    firstNegativeNumberPoint = -1;
                    localMaxNegativeProduct = 1;
                    localMaxPositiveProduct = -1;

                    if (wholeMaxProduct < 0) {
                        wholeMaxProduct = 0;
                    }
                }
            }

            return wholeMaxProduct;
        }
    }
}
