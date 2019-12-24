package zrx.com.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public static void quickSort2(int[] arr) {
        Objects.requireNonNull(arr);
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int start, int end) {
        if (end > start) {
            int pivot = arr[start];
            int pointToPivot = start;

            for (int i = start + 1; i <= end; i++) {
                if(arr[i]<pivot){
                    pointToPivot++;
                    swap(arr,i,pointToPivot);
                }
            }

            swap(arr,pointToPivot,start);

            quickSort2(arr,start,pointToPivot-1);
            quickSort2(arr,pointToPivot+1,end);
        }
    }

    /**
     * 归并排序法
     *
     * @param arr 要排序的数组
     */
    public static void mergeSort(int[] arr) {
        Objects.requireNonNull(arr);
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序内部实现
     *
     * @param arr   要排序的数组
     * @param start 开始元素索引，包含
     * @param end   结束元素索引，包含
     */
    private static void mergeSort(int[] arr, int start, int end) {
        MyRequire.requireTrue(end >= start);

        if (start == end) {
            //数组中只有一个元素
            return;
        } else {
            //数组中多个元素
            int mid = (start + end) / 2;
            //排序
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            //此时 [start, mid] 和 [mid + 1, end] 分别有序
            //那就合并

            //temp数组
            int[] temp = new int[end - start + 1];

            int i = start;//index [start, mid]
            int j = mid + 1;//index [mid + 1, end]
            int t = 0;//index temp

            //合并步骤一
            while (i <= mid && j <= end) {
                //合并
                if (arr[i] <= arr[j]) {
                    temp[t] = arr[i];
                    i++;
                } else {
                    temp[t] = arr[j];
                    j++;
                }
                t++;
            }

            //合并步骤二
            while (i <= mid) {
                temp[t] = arr[i];
                t++;
                i++;
            }
            while (j <= end) {
                temp[t] = arr[j];
                t++;
                j++;
            }

            //这时temp[] 应该满了
            MyRequire.requireTrue(t == temp.length);

            //复制到arr[start, end]
            for (i = start, t = 0; t < temp.length; t++, i++) {
                arr[i] = temp[t];
            }

            MyRequire.requireTrue(i == end + 1);

            //排序结束
            return;
        }

    }


    /**
     * 找无序数组 arr 种第 k 小的数
     * 方法：数组划分法
     *
     * @param arr 数组
     * @param k   要找的数，第k小
     * @return 要找的数
     */
    public static int select(int[] arr, int k) {
        MyRequire.requireTrue(k >= 0);
        MyRequire.requireTrue(k <= arr.length);

        int left = 0;
        int right = arr.length - 1;

        while (true) {
            final int pointOfPivot = partition(arr, left, right, left);

            if (pointOfPivot == k - 1) {
                return arr[pointOfPivot];
            } else if (pointOfPivot < k - 1) {
                left = pointOfPivot + 1;
            } else {
                right = pointOfPivot - 1;
            }

        }
    }

    /**
     * 数组划分，即快排的核心算法
     * arr[pointOfPivot] 即 pivot
     * 划分为 小于pivot pivot 大于等于pivot
     * <p>
     * 2019年12月17日 通过测试
     *
     * @param arr          数组 会发生变化
     * @param left0        数组左端 包含
     * @param right0       数组右端 包含
     * @param pointOfPivot 用于pivot的索引
     * @return pivot index
     */
    public static int partition(int[] arr, int left0, int right0, int pointOfPivot) {
        MyRequire.requireTrue(pointOfPivot >= left0);
        MyRequire.requireTrue(pointOfPivot <= right0);

        if (left0 == right0)
            return left0;

        int pivot = arr[pointOfPivot]; //提取 pivot
        arr[pointOfPivot] = arr[left0];//保存 arr[left0]

        int left = left0;
        int right = right0;
        boolean onRight = true;

        while (right > left) {
            if (onRight) {
                //right
                while (arr[right] >= pivot && right > left) {
                    right--;
                }
                arr[left] = arr[right];
                onRight = false;
            } else {
                //left
                while (arr[left] < pivot && right > left) {
                    left++;
                }
                arr[right] = arr[left];
                onRight = true;
            }
//            swap(arr, right, left);
        }

        MyRequire.requireTrue(right == left);
        arr[left] = pivot;

        return left;
    }


    public static String intArrayToString(Object arr) {
        if (!(arr instanceof int[])) {
            return arr.toString();
        }

        int[] array = (int[]) arr;
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("ints[");
//        for (int i = 0; i < array.length; i++) {
//            sb.append(array[i]);
//            sb.append(",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        sb.append("]");

        return Arrays.toString(array);
    }

    /**
     * 数组中指定范围是否反序
     * 这里说的有序是，从大到小，可以相等
     * 另见 isSorted
     *
     * @param arr            数组
     * @param startIncluding 起始位置，包含
     * @param endExcluding   结束位置，不包含
     * @return 是否有序
     */
    public static boolean isAntiSorted(int[] arr, int startIncluding, int endExcluding) {
        if (endExcluding <= startIncluding)
            MyRequire.throwRunTimeException("error in MyArrayTools::isSorted");

        if (endExcluding - startIncluding == 1)
            return true;

        for (int i = startIncluding; i < endExcluding - 1; i++) {
            if (arr[i] < arr[i + 1])
                return false;
        }

        return true;
    }

    public static boolean isAntiSorted(int[] arr) {
        return isAntiSorted(arr, 0, arr.length);
    }

    /**
     * 数组中指定范围是否有序
     * 这里说的有序是，从小到大，可以相等
     * 另见 isAntiSorted
     *
     * @param arr            数组
     * @param startIncluding 起始位置，包含
     * @param endExcluding   结束位置，不包含
     * @return 是否有序
     */
    public static boolean isSorted(int[] arr, int startIncluding, int endExcluding) {
        if (endExcluding <= startIncluding)
            MyRequire.throwRunTimeException("error in MyArrayTools::isSorted");

        if (endExcluding - startIncluding == 1)
            return true;


        for (int i = startIncluding; i < endExcluding - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }

        return true;
    }

    public static boolean isSorted(int[] arr) {
        return isSorted(arr, 0, arr.length);
    }

    /**
     * 自然数数组生成
     * 如n = 3
     * 返回 1 2 3
     *
     * @param n 数目
     * @return 自然数数组
     */
    public static int[] naturalNumber(int n) {
        MyRequire.requireTrue(n > 0);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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

    public static List<Integer> getIntList(int... ints) {
        return MyArrayTools.intArrayToList(ints);
    }

    /**
     * 数组加法，对ret加1，max[i].length代表ret第i位的权
     *
     * @param ret 被加数
     * @param max max[i].length代表ret第i位的权
     * @return 0-正常/ -1 溢出
     */
    public static int addOne(int[] ret, int[][] max) {
        int i = ret.length - 1;
        int carry = 1;
        while (carry != 0) {
            if (i == -1) {
                return -1;//溢出
            }
            ret[i]++;
            if (ret[i] == max[i].length) {
                ret[i] = 0;
                i--;
                carry = 1;
            } else {
                carry = 0;
            }
        }

        return 0;
    }

    public static int max(int...ints){
        Objects.requireNonNull(ints);
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if(ints[i]>max){
                max = ints[i];
            }
        }

        return max;
    }

    public static int min(int...ints){
        Objects.requireNonNull(ints);
        int min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if(ints[i]<min){
                min = ints[i];
            }
        }

        return min;
    }
}
