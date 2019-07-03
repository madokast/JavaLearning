package tool.tenKiloHours;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Stream;

public class Main {
    /**
     * length / min
     */
    private static int length=0;

    public static void main(String[] args) {
        final List<Activity> list  = new LinkedList<>();
        Stream.of(Entries.entries).forEach((e)->list.add(Activity.getInstance(e)));

        final long start = list.get(0).getDate().getTime();
        final Map<String,Integer> mapStatistic  = new HashMap<>();

        list.stream().forEach((e)->{
            length = length + e.getLength();
            long end = e.getDate().getTime();
            int days = (int)((end-start)/1000/60/60/24)+1;
            double avg = (double)length/days;
            System.out.println(e+String.format(" %7s %6s min",totaltime(length),String.format("%3.2f",avg)));
            statistic(mapStatistic,e);
        });

        printReport(mapStatistic);
        System.out.println(":::"+(double)length/Entries.ICHIWAN*100.0+"%:::");

    }

    /**
     * 统计，分别记录每个活动的总时长
     * @param map Map<String,Integer>
     * @param a 活动
     */
    public static void statistic(Map<String,Integer> map,Activity a){
        if(map.containsKey(a.getAct())){
            map.put(a.getAct(),map.get(a.getAct())+a.getLength());
        }else{
            map.put(a.getAct(),a.getLength());
        }
    }

    /**
     * 生成报表
     * @param map
     */
    public static void printReport(Map<String,Integer> map){
        System.out.println("----------report----------");
        int total = 0;
        for (int t:map.values()){
            total+=t;
        }
        System.out.println("total time: "+totaltime(total));
        for(String name:map.keySet()){
            System.out.print(String.format("%15s : ",name));
            System.out.print(String.format("%7s",totaltime(map.get(name))));
            System.out.print(String.format("%10.3f%%",(double)map.get(name)/total*100));
            System.out.println();
        }
    }

    /**
     * 将分钟计数的时间转为 hh mm 形式的字符串
     * @param length 分钟计数的时长
     * @return hh mm 形式的字符串
     */
    private static String totaltime(int length){
        return length/60+"h"+(length-length/60*60)+"m";
    }
}
