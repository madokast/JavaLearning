package madokast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] args) throws IOException {
        Properties p1 = new Properties();
        p1.setProperty("username","yeeku");
        p1.setProperty("password","123456");
        
        p1.store(new FileOutputStream("a.ini"),"comment line");

        System.out.println("p1 = " + p1);
        //p1 = {password=123456, username=yeeku}
        
        Properties p2 = new Properties();
        p2.setProperty("gender","male");
        System.out.println("p2 = " + p2);
        //p2 = {gender=male}
        
        p2.load(new FileInputStream("a.ini"));
        System.out.println("p2 = " + p2);
        //p2 = {password=123456, gender=male, username=yeeku}

        //a.ini
        //#comment line
        //#Wed Dec 12 20:38:18 CST 2018
        //password=123456
        //username=yeeku

        System.out.println(System.getProperty("user.dir"));
        //D:\Documents\JAVAlearning
        
    }
}
