package tool.tenKiloHours;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;

public class Main {
    /**
     * length / min
     */
    private static int length=0;
    private static String totaltime(int length){
        return length/60+"h"+(length-length/60*60)+"m";
    }

    public static void main(String[] args) {
        final List<Activity> list  = new LinkedList<>();
        Stream.of(Entries.entries).forEach((e)->list.add(Activity.getInstance(e)));

        final long start = list.get(0).getDate().getTime();

        list.stream().forEach((e)->{
            length = length + e.getLength();
            long end = e.getDate().getTime();
            int days = (int)((end-start)/1000/60/60/24)+1;
            double avg = (double)length/days;
            System.out.println(e+String.format(" %7s %6s min",totaltime(length),String.format("%3.2f",avg)));
        });


        System.out.println(":::"+(double)length/Entries.ICHIWAN*100.0+"%:::");

    }
}
