package zrx.com.others;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;
import zrx.com.leetcode.utils.MyRandom;
import zrx.com.leetcode.utils.MyTimer;

import java.util.Arrays;

/**
 * Description
 * 双基准快排
 * <p>
 * Data
 * 2019/12/1 17:30
 *
 * @author zrx
 * @version 1.0
 */

public class MyDualPivotQuicksort {
    public static void go() {
        MyTools.printCurrentMethod(true);
        System.err.println("双基准快排");

        final MyDualPivotQuicksort myDualPivotQuicksort = new MyDualPivotQuicksort();
        for (int i = 0; i < 5; i++) {
            final int[] ints = MyRandom.randomIntArray(0, 99, 20);
            System.out.println("要排序的数组是" + Arrays.toString(ints));
            myDualPivotQuicksort.sort(ints);
            System.out.println("排序结果是" + Arrays.toString(ints));
            if (MyArrayTools.isSorted(ints)) {
                System.out.println("排序正确");
            } else {
                System.err.println("排序错误!!!");
            }
            System.out.println();
        }

        System.err.println("效率测试");
        long dualTime = 0;
        long traditionTime = 0;
        long apiTime = 0;
        long apiTimeParalle = 0;
        for (int i = 0; i < 10; i++) {
            final int[] bigs = MyRandom.randomIntArray(Integer.MIN_VALUE / 5, Integer.MAX_VALUE / 5, 100 * 100 * 100);
            int[] copy = Arrays.copyOf(bigs, bigs.length);
            int[] copy2 = Arrays.copyOf(bigs, bigs.length);
            int[] copy3 = Arrays.copyOf(bigs, bigs.length);
            MyTimer.runtimeBack();
            myDualPivotQuicksort.sort(bigs);
            dualTime += MyTimer.runtimeBack();

            MyTimer.runtimeBack();
            MyArrayTools.quickSort(copy);
            traditionTime += MyTimer.runtimeBack();

            MyTimer.runtimeBack();
            Arrays.sort(copy2);
            apiTime += MyTimer.runtimeBack();

            MyTimer.runtimeBack();
            Arrays.parallelSort(copy3);
            apiTimeParalle += MyTimer.runtimeBack();

        }
        System.out.println("双基准快排：" + dualTime +"ms");
        System.out.println("传统快排：" + traditionTime +"ms");
        System.out.println("内置排序：" + apiTime +"ms");
        System.out.println("内置并行排序：" + apiTimeParalle +"ms");
    }

    private void sort(int[] arr, int startIncluding, int endIncluding) {
        if (startIncluding >= endIncluding)
            return;

        //找到基准
        int p1 = Math.min(arr[startIncluding], arr[endIncluding]);
        int p2 = Math.max(arr[startIncluding], arr[endIncluding]);

        arr[startIncluding] = p1;
        arr[endIncluding] = p2;

        //分界指针
        int pLess = startIncluding;
        int pLarger = endIncluding;


        //扫描指针
        for (int i = pLess + 1; i < pLarger; i++) {
            if (arr[i] <= p1) {
                pLess++;
                MyArrayTools.swap(arr, pLess, i);
            } else if (arr[i] >= p2) {
                pLarger--;
                MyArrayTools.swap(arr, pLarger, i);
                i--;//回去再看看
            } else {
                //mid
                //do nothing
            }
        }

        //递归
        sort(arr, startIncluding, pLess);
        sort(arr, pLess + 1, pLarger - 1);
        sort(arr, pLarger, endIncluding);
    }

    private void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


}
