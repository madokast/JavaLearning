package 函数式接口;

import java.io.InputStream;
import java.util.Arrays;
import java.util.function.Supplier;

public class 求数组最大值 {
    public static int getMax(Supplier<Integer> s){
        return s.get();
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,231,5,24,100};

        System.out.println(getMax(()-> {
            int max = arr[0];
            for (int t:arr) {
                if(max<t){
                    max=t;
                }
            }
            return max;
        }));
    }
}
