package zrx.com.others;

import zrx.com.MultiThread.MyTools;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Description
 * 三种排序算法
 * <p>
 * Data
 * 2019/11/27 21:40
 *
 * @author zrx
 * @version 1.0
 */

public class Permutation {
    public static void go(){
        Permutation permutation = new Permutation();

        for (int i = 1; i <= 4; i++) {
            final List<String> list = permutation.insertPlace(i);
            System.out.println("对于到" +i+ "的排列是：");
            list.forEach(e-> System.out.print(e+" "));
            System.out.println();
            permutation.check(list,i);
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
        MyTools.printCurrentMethod(true);
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
