package N215;

import java.security.cert.TrustAnchor;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//1557326872351L
        System.out.println("(1557326872351L/1000/3600/24/365) = " + (1557326872351L/1000/3600/24/365));//49

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));//2019-05-08 23-08-21

        try {
            Date date2 = simpleDateFormat.parse("2019-05-08 23-08-21");
            System.out.println("date2 = " + date2);
        }
        catch (Exception e){
            System.out.println("e = " + e);//Wed May 08 23:08:21 CST 2019
        }
    }
}
