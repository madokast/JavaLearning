package madokast;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LishMain {
    public static void main(String[] args) {

        List fixedList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("fixedList = " + fixedList);
        fixedList.forEach(System.out::println);
        System.out.println(fixedList.getClass());//class java.util.Arrays$ArrayList

        Iterator it = fixedList.iterator();
        while(it.hasNext())
            System.out.print(it.next()+"\t");
        //1	2	3	4	5	6	7	8	9
    }
}
