package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ticket {
    public static Integer signal = 123456;

    private static HashMap<String,Integer> hashMap =  new HashMap<>();

    private static int num = 100;

    public static boolean isEmpty(){
        return num<=0;
    }

    public static int getNum(){
        return num;
    }

    public static void sell(){
        num--;
    }

    public static void report(String name,int all){
        hashMap.put(name,all);
    }

    public static void reportAll(){
        for (Map.Entry<String, Integer> stringIntegerEntry : Ticket.hashMap.entrySet()) {
            System.out.println("窗口"+stringIntegerEntry.getKey()+"售出"+stringIntegerEntry.getValue()+"张票");
        }
    }
}
