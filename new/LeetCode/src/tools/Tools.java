package tools;

import java.util.Arrays;

public class Tools {
    public static void printIntArr(int[] arr){
        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
        System.out.println();
    }
}
