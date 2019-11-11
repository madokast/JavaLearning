package zrx.com.leetcode.Q0440;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem MyTools bit easier,
 * all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output:
 * 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 我的想法，pair-map法
 *
 * 结果：一次通过
 * Runtime: 89 ms, faster than 44.12% of Java online submissions for 4Sum II.
 * Memory Usage: 100.6 MB, less than 8.00% of Java online submissions for 4Sum II.
 *
 * 优化以后
 * Runtime: 80 ms, faster than 66.21% of Java online submissions for 4Sum II.
 * Memory Usage: 58.7 MB, less than 64.00% of Java online submissions for 4Sum II.
 *
 * <p>
 * Data
 * 2019/11/9 10:12
 *
 * @author zrx
 * @version 1.0
 */

public class Q0454FourSumII {
    public static void test(){
        final int count = new Solution0454().fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
                );
        System.out.println(count);
    }
}

class Solution0454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ansNum = 0;

        //对数组CD 构建pair-map
//        Map<Integer, List<Doublet>> pairMap = new HashMap<>();
        Map<Integer,Integer> pairMap = new HashMap<>();


        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];

                pairMap.put(sum,pairMap.getOrDefault(sum,0)+1);

            }
        }

        //对AB搜索
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int newTarget = -A[i] -B[j];

                ansNum+=pairMap.getOrDefault(newTarget,0);
            }
        }

        return ansNum;
    }
}


/**
 * 存放一对index
 * 代表两个数组的分别的两个下标
 * 用于pairMap
 */
class Doublet{
    int a1;
    int a2;

    public Doublet(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }
}