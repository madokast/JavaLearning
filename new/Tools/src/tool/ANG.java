package tool;

import java.util.Scanner;

public class ANG {
    public static void main(String[] args) {
        double ang = 15.0;
        double length = 0.1963;
        double angn , lengthn ;
        double angTol = 0.0 ;
        String s ;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            s = scanner.next();
            try {
                angn = Double.parseDouble(s);
                angTol+=angn;
                System.out.println(Math.round(angn/ang*length*10000)/10000.+" "+Math.round(angn*10000)/10000.);
            }catch (Exception e)
            {
                System.out.println("angTol = " + angTol);
                angTol = 0.0 ;
            }
        }
    }
}