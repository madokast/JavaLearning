package zrx.com.others;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyArrayTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 三种排序算法
 * 2019年12月1日 完成
 * <p>
 * Data
 * 2019/11/27 21:40
 *
 * @author zrx
 * @version 1.0
 */

public class Permutation {
    public static void go(){
        MyTools.printCurrentMethod(true);
        Permutation permutation = new Permutation();

        System.err.println("排序算法之插入法");
        for (int i = 1; i <= 4; i++) {
            final List<String> list = permutation.insertPlace(i);
            System.out.print("排序算法之插入法 对于到" +i+ "的排列是：");
            list.forEach(e-> System.out.print(e+" "));
            System.out.println();
            permutation.check(list,i);
            System.out.println();
        }


        System.err.println();
        System.err.println("排序算法之johnson_trotter");
        for (int i = 1; i <= 4; i++) {
            final List<String> list = permutation.johnson_trotter(i);
            System.out.print("排序算法之johnson_trotter 对于到" +i+ "的排列是：");
            list.forEach(e-> System.out.print(e+" "));
            System.out.println();
            permutation.check(list,i);
            System.out.println();
        }

        System.err.println();
        System.err.println("排序算法之dictionaryOrder");
        for (int i = 1; i <= 4; i++) {
            final List<String> list = permutation.dictionaryOrder(i);
            System.out.print("排序算法之dictionaryOrder 对于到" +i+ "的排列是：");
            list.forEach(e-> System.out.print(e+" "));
            System.out.println();
            permutation.check(list,i);
            System.out.println();
        }



    }

    /**
     * 字典序
     * @param n 数目
     * @return 排序结果
     */
    private List<String> dictionaryOrder(int n){
        List<String> ret = new ArrayList<>(factorial(n));

        final int[] nums = MyArrayTools.naturalNumber(n);

        //初始的第一组
        ret.add(arrayToString(nums));

        if(n==1){
            return ret;
        }

        while (!MyArrayTools.isAntiSorted(nums)){
            if(nums[nums.length-2]<nums[nums.length-1]){
                MyArrayTools.swap(nums,nums.length-2,nums.length-1);
            }else {
                //找最长反序子数组
                int maxIndex = nums.length-2;
                while (maxIndex>=0&&nums[maxIndex]>nums[maxIndex+1]){
                    maxIndex--;
                }
                //此时maxIndex未反序子数组的前一个
                int k = nums[maxIndex];
                //找子数组中比k大的最小数
                int largeK = Integer.MAX_VALUE;
                int largeKIndex = -1;
                for (int i = maxIndex+1; i < nums.length; i++) {
                    if(nums[i]>k){
                        if(largeK>nums[i]){
                            largeK = nums[i];
                            largeKIndex = i;
                        }
                    }
                }
                //找到了largeK
                //swap
                MyArrayTools.swap(nums,maxIndex,largeKIndex);
                //对maxIndex后面的数组排正序
                Arrays.sort(nums,maxIndex+1,nums.length);
            }

            //out
            ret.add(arrayToString(nums));
        }

        return ret;
    }


    private List<String> johnson_trotter(int n){
        List<String> ret = new ArrayList<>(factorial(n));

        final int[] nums = MyArrayTools.naturalNumber(n);
        final boolean[] arr = new boolean[n];//箭头
        Arrays.fill(arr,true);

        //初始的第一组
        ret.add(arrayToString(nums));


        int[] changePart;
        while ((changePart=interchanghePart(nums,arr))!=null){
            //存在
            //交换
            swap(nums,changePart[0],changePart[1]);
            swap(arr,changePart[0],changePart[1]);

            //输出
            ret.add(arrayToString(nums));

            //把大于k的，箭头取反
            int k = Math.max(nums[changePart[0]],nums[changePart[1]]);
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]>k){
                    arr[i]=!arr[i];
                }
            }
        }

        return ret;
    }

    private void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void swap(boolean[] arr,int i,int j){
        boolean t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private String arrayToString(int[] arr){
        final StringBuilder sb = new StringBuilder(arr.length);
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    /**
     * johnson_trotter中 查看是否存在交换对
     * 若存在，返回的交换对
     * 不存在返回null
     * @param nums 数字
     * @param arr 箭头
     * @return 交换对的索引
     */
    private int[/*2*/] interchanghePart(int[] nums,boolean[] arr){
        int maxChangeable = -1;
        int maxChangeableIndex = -1;
        boolean change = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]){
                //←
                if(i-1>=0&&nums[i-1]<nums[i]){
                    //左边有东西
                    if(nums[i]>maxChangeable){
                        maxChangeable = nums[i];
                        maxChangeableIndex = i;
                        change = true;//左边交换
                    }
                }
            }else {
                //→
                if(i+1<arr.length&&nums[i]>nums[i+1]){
                    //右边有，可交换
                    if(nums[i]>maxChangeable){
                        maxChangeable = nums[i];
                        maxChangeableIndex = i;
                        change = false;//右边交换
                    }
                }
            }
        }

        if(maxChangeableIndex!=-1){
            //有
            if(change){
                //左交换
                return new int[]{maxChangeableIndex-1,maxChangeableIndex};
            }else {
                //右交换
                return new int[]{maxChangeableIndex,maxChangeableIndex+1};
            }
        }else {
            //没有
            return null;
        }
    }



    private void check(final List<String> list,int n){
        int fn = factorial(n);
        int size = list.size();
        boolean ans = true;
        if(fn==size){
            System.out.println("排序数目正确，是" + size);
        }else {
            ans = false;
            System.err.println("排数数目错误，应为" + fn +"，但是计算出的是" +size);
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length()!=n){
                ans = false;
                System.err.println("错误，排序项长度不对");
            }
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))){
                    ans = false;
                    System.err.println("错误，排序项目存在相同者");
                }
            }
        }

        if(ans){
            System.out.println("排序是正确的");
        }
    }

    private int factorial(int n){
        if(n<=1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }

    private List<String> insertPlace(int n){
//        MyTools.printCurrentMethod(true);
        final List<LinkedList<Integer>> ans = insert(new ArrayList<LinkedList<Integer>>(), n);

        final List<String> ansList = new ArrayList<>();

        ans.forEach(ll->{
            final StringBuilder stringBuilder = new StringBuilder(ll.size());
            ll.forEach(stringBuilder::append);
            ansList.add(stringBuilder.toString());
        });

        return ansList;
    }

    private List<LinkedList<Integer>> insert(List<LinkedList<Integer>> origins,int n){
        final List<LinkedList<Integer>> ret = new ArrayList<>();
        if(origins==null||origins.size()==0){
            ret.addAll(insert(new LinkedList<Integer>(),n));
        }else {
            origins.forEach(c->ret.addAll(insert(c,n)));
        }


        if(n>1){
            return insert(ret,n-1);
        }else {
            return ret;
        }
    }

    private List<LinkedList<Integer>> insert(LinkedList<Integer> origin,int k){
        List<LinkedList<Integer>> ret = new ArrayList<>();

        if(origin==null||origin.isEmpty()){
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(k);
            ret.add(linkedList);

            return ret;
        }

        int place = origin.size()+1;
        for (int i = 0; i < place; i++) {
            LinkedList<Integer> copy = copy(origin);
            copy.add(i,k);

            ret.add(copy);
        }

        return ret;
    }

    private LinkedList<Integer> copy(LinkedList<Integer> linkedList){
        return new LinkedList<>(linkedList);
    }
}
