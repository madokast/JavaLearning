package madokast;

import java.util.Calendar;

public class DateClassMain {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));

        c.set(2013,Calendar.JANUARY,10,10,2,10);
        System.out.println(c.getTime());
        c.add(Calendar.YEAR,-1);
        System.out.println(c.getTime());

        c.set(Calendar.MONTH,13);//lenient
        System.out.println(c.getTime());
    }
}
