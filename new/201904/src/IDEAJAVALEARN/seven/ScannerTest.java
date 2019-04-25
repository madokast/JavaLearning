package IDEAJAVALEARN.seven;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.equals("exit"))
                break;
            System.out.println(s);
        }
    }
}
