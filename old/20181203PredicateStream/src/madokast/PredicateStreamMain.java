package madokast;

import java.util.*;
import java.util.function.Predicate;

public class PredicateStreamMain {
    public static void main(String[] args) {
        int[] a=new int[20];
        for(int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(100);
            System.out.print(a[i]+"\t");
        }
        System.out.println("\n"+count(a,ele->(Integer)ele>40));
    }

    public  static int count(int[] a, Predicate pd){
        int total=0;
        for(int i=0;i<a.length;i++){
            if(pd.test(a[i]))
                total++;
        }
        return total;
        }

    }
