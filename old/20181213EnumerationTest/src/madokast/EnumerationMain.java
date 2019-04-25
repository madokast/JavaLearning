package madokast;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationMain {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(12);
        v.add(1212);
        v.add(32);
        v.add(22);
        System.out.println("v = " + v);

        Enumeration e = v.elements();
        while(e.hasMoreElements())
            System.out.println(e.nextElement());

        //v = [12, 1212, 32, 22]
        //12
        //1212
        //32
        //22
    }
}
