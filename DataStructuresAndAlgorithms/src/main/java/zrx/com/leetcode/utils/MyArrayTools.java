package zrx.com.leetcode.utils;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/11/6 11:34
 *
 * @author zrx
 * @version 1.0
 */

public class MyArrayTools {
    /**
     * 2019年11月6日
     * 二分查找算法
     *
     * @param arr    数组
     * @param target 目标
     * @return 返回索引。找不对返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) { // add =
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int[] getIntArray(int...ints){
        return ints;
    }
}
