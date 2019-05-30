package threadCommunicate.musukasii;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    private Room(){}

    private static final Lock LOCK = new ReentrantLock();

    private static final int MAX = 5;
    private static final Set<String> stringSet = new HashSet<>(MAX);

    public static boolean isEmpty(){
        return stringSet.isEmpty();
    }

    public static boolean isFull(){
        return stringSet.size()==MAX;
    }

    public static String shop(){
        if(isEmpty()){
            throw new Error("没有产品");
        }

        String s = stringSet.iterator().next();
        stringSet.remove(s);

        return s;
    }

    public static void producr(String production){
        if(isFull()){
            throw new Error("空间已满");
        }

        stringSet.add(production);
    }

    public static Lock getLOCK(){
        return LOCK;
    }
}
