package IDEAJAVALEARN.stringTest;

import java.util.HashMap;
import java.util.Random;

public class Exes1 {
    public static void main(String[] args) {
        int len = 100;
        String s = new String(getBytes(len));
        System.out.println("s = " + s);
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!hashMap.containsKey(c))
                hashMap.put(c,1);
            else{
                int val = hashMap.get(c);
                hashMap.remove(c);
                hashMap.put(c,val+1);
            }
        }

        hashMap.forEach((Character c,Integer i)->
            System.out.println("字符"+c+"出现"+i+"次")
        );
    }
    
    public static byte[] getBytes(int len){
        Random random = new Random();
        
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) (random.nextInt(40)+50);
        }
        
        return bytes;
    }
}
