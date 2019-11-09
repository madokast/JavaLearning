package zrx.com.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 数组相关utils
 * 包括list
 * <p>
 * Data
 * 2019/11/6 11:34
 *
 * @author zrx
 * @version 1.0
 */

public class MyArrayTools {
    public static int[] getSortedArray(int... ints) {
        return null;
    }

    /**
     * 快速排序法
     *
     * @param arr 数组
     */
    public static void quickSort(int[] arr) {
//        Arrays.sort(arr);//这个还慢些
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left0, int right0) {
        //跳出递归条件
        if (left0 >= right0)
            return;

        int pivot = arr[left0];//支点; 枢轴; 中心点; 最重要的人(或事物); 中心; 核心;
        boolean onRight = true;//当前是哪个指针再走

        //后期还需要right和left的值
        int left = left0;
        int right = right0;

        while (left < right) {//不止一个元素
            if (onRight) {
                //一直走
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                if (right != left) {
                    arr[left] = arr[right];
                }
                onRight = false;
            } else {
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                if (left != right) {
                    arr[right] = arr[left];
                }
                onRight = true;
            }


        }

        //放回去
        arr[left] = pivot;

        quickSort(arr, left0, left - 1);
        quickSort(arr, right + 1, right0);

    }


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

    public static int[] getIntArray(int... ints) {
        return ints;
    }

    public static List<Integer> intArrayToList(int[] ints) {
        final ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        return list;
    }

    public static int[] listToIntArray(List<Integer> list) {
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static int sum(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    /**
     * 首先list必须是有序数组
     * 若要插入aim，是该插入哪个index
     * 例如{1,3}
     * 插入1，则应插入0
     * 插入2，则应插入1
     * 插入3，则应插入1
     * 二分查找实现
     *
     * @param list 有序，升序
     * @return
     */
    public static int insertIndex(List<Integer> list, int aim) {
        return insertIndex(list, aim, 0, list.size() - 1);
    }

    private static int insertIndex(List<Integer> list, int aim, int left, int right) {
        if (left == right) {
            if (list.get(left) >= aim)
                return left;
            else if (list.get(left) < aim)
                return left + 1;
        }

        int mid = (left + right) / 2;
        if (list.get(mid) == aim) {
            return mid;
        } else if (list.get(mid) > aim) {
            return insertIndex(list, aim, left, mid);
        } else {
            return insertIndex(list, aim, mid + 1, right);
        }
    }

    /**
     * list种大于aim的数的个数
     * list已经排序，升序
     *
     * @param aim  目标
     * @param list 集合
     * @return 个数
     */
    public static int numberInListBiggerThan(int aim, List<Integer> list) {
        final int indexOf = list.indexOf(aim);
        if (indexOf != -1) {
            return list.size() - indexOf - 1;
        } else {
            return list.size() - insertIndex(list, aim);
        }
    }
}
