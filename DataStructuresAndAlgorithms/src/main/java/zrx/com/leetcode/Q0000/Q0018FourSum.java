package zrx.com.leetcode.Q0000;

import zrx.com.leetcode.utils.MyArrayTools;

import java.util.*;

/**
 * Description
 * Given an array nums of n integers and an integer target,
 * are there elements MyTools, b, c, and d in nums such that MyTools + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 我的想法，pair-map法
 * 一次性出结果 Runtime:
 * 32 ms, faster than 31.42% of Java online submissions for 4Sum.
 * Memory Usage: 39.7 MB, less than 68.12% of Java online submissions for 4Sum.
 *
 * <p>
 * Data
 * 2019/11/9 9:34
 *
 * @author zrx
 * @version 1.0
 */

public class Q0018FourSum {
    public void test(){
        final Solution0018 s = new Solution0018();
        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}

class Solution0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Quadruplet> ansSet = new HashSet<>();
        List<List<Integer>> ansList = new ArrayList<>();
        Map<Integer,List<Doublet>> pairMap = new HashMap<>();

        // make map
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pair = nums[i]+nums[j];
                if(pairMap.containsKey(pair)){
                    pairMap.get(pair).add(new Doublet(i,j));
                }else {
                    List<Doublet> list = new ArrayList<>();
                    list.add(new Doublet(i,j));
                    pairMap.put(pair,list);
                }
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int newTarget = target - nums[i] - nums[j];
                if(pairMap.containsKey(newTarget)){
                    final List<Doublet> list = pairMap.get(newTarget);
                    for (Doublet doublet : list) {
                        final Quadruplet quadruplet = Quadruplet.toQuadruplet(nums,doublet, new Doublet(i, j));
                        if(quadruplet!=null){
                            ansSet.add(quadruplet);
                        }
                    }
                }
            }
        }

        for (Quadruplet quadruplet : ansSet) {
            ansList.add(quadruplet.toList());
        }

        return ansList;

    }
}

/**
 * 存放一对index
 * 代表两个数组下标
 * 用于pairMap
 */
class Doublet{
    int a1;
    int a2;

    public Doublet(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public boolean hasAnythingSame(Doublet d){
        if(this.a1==d.a1
                ||this.a1==d.a2
                ||this.a2==d.a1
                ||this.a2==d.a2){
            return true;
        }else {
            return false;
        }
    }
}

/**
 * 存放解，因为解里面即四个数
 * 对解的四个数自动排序
 * 同时重写equals
 * 这样可以利用set去除重复项
 *
 * 解由两个Doublet获取，注意当两个Doublet种有重复项目时，不会生成解
 */
class Quadruplet{
    private int[] container;
    private Quadruplet(int a1,int a2,int a3, int a4){
        container = MyArrayTools.getIntArray(a1,a2,a3,a4);
        MyArrayTools.quickSort(container);
    }

    //注意。两个Doublet种有重复项目时，不会生成解
    public static Quadruplet toQuadruplet(int[] nums,Doublet d1,Doublet d2){
        //两个Doublet种有重复项目时，不会生成解
        if(d1.hasAnythingSame(d2)){
            return null;
        }

        return new Quadruplet(nums[d1.a1],nums[d1.a2],nums[d2.a1],nums[d2.a2]);
    }

    public List<Integer> toList(){
        return MyArrayTools.intArrayToList(container);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadruplet that = (Quadruplet) o;

        return Arrays.equals(container, that.container);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(container);
    }
}
