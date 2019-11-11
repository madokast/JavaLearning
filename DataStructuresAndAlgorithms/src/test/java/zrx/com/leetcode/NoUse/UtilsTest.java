package zrx.com.leetcode.NoUse;

import org.junit.Assert;
import org.junit.Test;
import zrx.com.leetcode.utils.*;
import zrx.com.leetcode.utils.singlyLinkedList.ListNode;

/**
 * Description
 * utils 包测试
 * <p>
 * Data
 * 2019/11/6 10:32
 *
 * @author zrx
 * @version 1.0
 */


public class UtilsTest {
    @Test
    public void test() {
    }

//    @Test
    public void testListNode() {
        final ListNode head = ListNode.make(1, 2, 3, 4, 5);
        head.print();
        final ListNode head2 = ListNode.make(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        head2.print();
    }

//    @Test
    public void testNumberInListBiggerThan() {
        System.out.println(MyArrayTools.numberInListBiggerThan(1, MyArrayTools.intArrayToList(new int[]{2})));//1
        System.out.println(MyArrayTools.numberInListBiggerThan(2, MyArrayTools.intArrayToList(new int[]{2})));//0
        System.out.println(MyArrayTools.numberInListBiggerThan(3, MyArrayTools.intArrayToList(new int[]{2})));//0

        System.out.println("------------------------");

        System.out.println(MyArrayTools.numberInListBiggerThan(1, MyArrayTools.intArrayToList(new int[]{2, 4})));//2
        System.out.println(MyArrayTools.numberInListBiggerThan(2, MyArrayTools.intArrayToList(new int[]{2, 4})));//1
        System.out.println(MyArrayTools.numberInListBiggerThan(3, MyArrayTools.intArrayToList(new int[]{2, 4})));//1
        System.out.println(MyArrayTools.numberInListBiggerThan(4, MyArrayTools.intArrayToList(new int[]{2, 4})));//0
        System.out.println(MyArrayTools.numberInListBiggerThan(5, MyArrayTools.intArrayToList(new int[]{2, 4})));//0

        System.out.println("------------------------");

        System.out.println(MyArrayTools.numberInListBiggerThan(1, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//3
        System.out.println(MyArrayTools.numberInListBiggerThan(2, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//2
        System.out.println(MyArrayTools.numberInListBiggerThan(3, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//2
        System.out.println(MyArrayTools.numberInListBiggerThan(4, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//1
        System.out.println(MyArrayTools.numberInListBiggerThan(5, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//1
        System.out.println(MyArrayTools.numberInListBiggerThan(6, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//0
        System.out.println(MyArrayTools.numberInListBiggerThan(7, MyArrayTools.intArrayToList(new int[]{2, 4, 6})));//0
    }

//    @Test
    public void insertIndexTest() {
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2}), 1));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2}), 2));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2}), 3));//1

        System.out.println("------------------------");

        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4}), 1));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4}), 2));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4}), 3));//1
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4}), 4));//1
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4}), 5));//2


        System.out.println("------------------------");

        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 1));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 2));//0
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 3));//1
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 4));//1
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 5));//2
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 6));//2
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 7));//3
        System.out.println(MyArrayTools.insertIndex(MyArrayTools.intArrayToList(new int[]{2, 4, 6}), 8));//3
    }

//    @Test
    public void testQuickSort() {
        testQuickSorted(1);
        testQuickSorted(1, 2);
        testQuickSorted(2, 1);
        testQuickSorted(1, 1);
        testQuickSorted(1, 1, 2);
        testQuickSorted(2, 1, 1);
        testQuickSorted(2, 1, 0);
        testQuickSorted(1, 2, 0);

        testQuickSorted(MyRandom.randomIntArray(9, 6));
        testQuickSorted(MyRandom.randomIntArray(9, 6));
        testQuickSorted(MyRandom.randomIntArray(9, 6));

        testQuickSorted(MyRandom.randomIntArray(99, 30));
        testQuickSorted(MyRandom.randomIntArray(99, 30));
        testQuickSorted(MyRandom.randomIntArray(99, 30));
    }

    private void testQuickSorted(int... ints) {
        final int[] array1 = MyArrayTools.getIntArray(ints);
        MyPrinter.printIntArray(array1);
        MyArrayTools.quickSort(array1);
        MyPrinter.printIntArray(array1);
        Assert.assertTrue(MyRequire.isOrdered(array1));
        System.out.println("--------------------");
    }

//    @Test
    public void binarySearchTest() {
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 1));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 2));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 3));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 3), 4));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4), 3));

        System.out.println("-------------");

        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 3));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 4));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), 1));
        System.out.println(MyArrayTools.binarySearch(MyArrayTools.getIntArray(1, 2, 4, 5), -1));

    }

//    @Test
    public void randomIntArrayTest() {
        final int[] randomIntArray = MyRandom.randomIntArray(3, 5, 10);
        MyPrinter.printIntArray(randomIntArray, 4, true);
    }


//    @Test
    public void printIntArrayTest() {
        MyPrinter.printIntArray(new int[]{1, 2, 3}, 4, true);
        MyPrinter.printIntArray(new int[]{1, 2, 3}, 4, false);
    }

}
