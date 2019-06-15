package Tools;

import java.util.*;

public class ArrToString {
    public static String arrToString(int[] arr){
        List<Integer> list = new ArrayList<>(arr.length);
        Arrays.stream(arr).forEach(e->list.add(e));
        return list.toString();
    }

    public static String arrToString(int[] arr,int limit){
        List<Integer> list = new ArrayList<>(arr.length);
        Arrays.stream(arr).limit(limit).forEach(e->list.add(e));
        return list.toString();
    }

    public static void printArrat(int[] arr){
        System.out.println(arrToString(arr));
    }

}
