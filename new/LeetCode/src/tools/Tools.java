package tools;

import java.util.Arrays;
import java.util.List;

public class Tools {
    public static void printIntArr(int[] arr){
        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
        System.out.println();
    }

    public static int maxList(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for (int t : list) {
            if (t > max)
                max = t;
        }
        return max;
    }
}
