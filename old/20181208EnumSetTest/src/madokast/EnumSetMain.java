package madokast;

import java.util.Collections;
import java.util.EnumSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class EnumSetMain {
    public static void main(String[] args) {
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println("en1 = "+es1);
        //en1 = [SPRING, SUMMER, FALL, WINTER]

        EnumSet es2 = EnumSet.of(Season.SPRING,Season.SUMMER);
        EnumSet es3 = EnumSet.complementOf(es2);
        System.out.println("es2 = " + es2);//es2 = [SPRING, SUMMER]
        System.out.println("es3 = " + es3);//es3 = [FALL, WINTER]

        es2.add(Season.FALL);
        System.out.println("es2 = " + es2);//es2 = [SPRING, SUMMER, FALL]

        SortedSet s = Collections.synchronizedSortedSet(new TreeSet<Season>());
        s.add(Season.SPRING);
        s.add(Season.SUMMER);
        s.add(Season.FALL);
        System.out.println("s = " + s);
        //s = [SPRING, SUMMER, FALL]
        
        EnumSet es4 = EnumSet.copyOf(s);
        System.out.println("es4 = " + es4);
        //es4 = [SPRING, SUMMER, FALL]

    }


}

enum Season{
    SPRING,SUMMER,FALL,WINTER
}
