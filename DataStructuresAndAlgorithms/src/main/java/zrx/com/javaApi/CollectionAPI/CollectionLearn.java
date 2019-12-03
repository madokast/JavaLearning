package zrx.com.javaApi.CollectionAPI;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.*;
import java.util.concurrent.CompletionStage;

/**
 * Description
 * 学习集合类
 * <p>
 * Data
 * 2019/11/30 14:24
 *
 * @author zrx
 * @version 1.0
 */

public class CollectionLearn {
    public static void go(){
        new CollectionLearn().collections();
        new CollectionLearn().arrays();
    }

    private void arrays(){
        MyTools.printCurrentMethod(true);

        Arrays arrays;

        System.err.println("toString");
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        System.out.println();
        System.err.println();



        System.err.println("parallelPrefix是什么");
        final int[] intArray = MyArrayTools.getIntArray(11, 12, 13, 14, 15);
        System.out.println("数组是" + Arrays.toString(intArray));
        System.out.println("在parallelPrefix中的x和y分别是");
        Arrays.parallelPrefix(intArray,(x,y)->{
            System.out.println(Arrays.toString(new int[]{x,y})+" ");
            return -1;
        });
        System.out.println();
        System.out.println("之后数组是" + Arrays.toString(intArray));

        CompletionStage completionStage;

    }

    private void collections(){
        MyTools.printCurrentMethod(true);

        Collections collections;

        //copy
        System.err.println("copy");
        List<Integer> dest = Arrays.asList(1,1,2,2,3);
        List<Integer> src = Arrays.asList(9,8,7);
        System.out.println("dest = " + dest);
        System.out.println("src = " + src);
        Collections.copy(dest,src);
        System.out.println("dest = " + dest);


        //rotate
        System.out.println();
        System.err.println("rotate");
        List<Character> rotateList = Arrays.asList('a','b','c','x','y','z');
        System.out.println("rotateList = " + rotateList);
        Collections.rotate(rotateList,2);
        System.out.println("rotateList = " + rotateList);

        //disjoint
        System.out.println();
        System.err.println("disjoint");
        Collection<Integer> c1 = Arrays.asList(1,2,3,4);
        Collection<Integer> c2 = Set.of(5, 6, 7, 8);
        Collection<Integer> c3 = Set.of(1,5, 6, 7, 8);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("Collections.disjoint(c1,c2) = " + Collections.disjoint(c1, c2));
        System.out.println("Collections.disjoint(c1,c3) = " + Collections.disjoint(c1, c3));
    }

    private void compareLearn(){
        MyTools.printCurrentMethod(true);

        System.out.println("学习了 Comparable Comparator");

        Comparable comparable;
        Comparator comparator;

        Throwable throwable;

        Scanner scanner;
    }
}
