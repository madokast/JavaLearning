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

        list.stream().forEach((e)->{
            length = length + e.getLength();
            System.out.println(e+" "+totaltime(length));
        });

        long start = list.get(0).getDate().getTime();
        long end = list.get(list.size()-1).getDate().getTime();
        int days = (int)((end-start)/1000/60/60/24)+1;
        double avg = (double)length/days;
        System.out.println("\ntotal day:"+days+"  avg="+String.format("%.3f",avg)+"min");
        System.out.println(":::"+(double)length/Entries.ICHIWAN*100.0+"%:::");

    }
}
