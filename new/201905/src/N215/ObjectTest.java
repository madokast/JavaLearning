package N215;

import java.util.Objects;

/**
 * Object
 * toString
 * equals
 */
public class ObjectTest {
    public static void main(String[] args) {
        Person p = new Person("miao~",20);
        String s = p.toString();
        System.out.println("s = " + s);
        System.out.println("p = " + p);
        //s = N215.Person@b4c966a
        //p = N215.Person@b4c966a

        //s = Person{name='miao~', age=20}
        //p = Person{name='miao~', age=20}

        Person p1 = new Person("miao~",20);
        Person p2 = new Person("maio",21);
        Person p3 = p;
        System.out.println("p.equals(p1) = " + p.equals(p1));
        System.out.println("p.equals(p2) = " + p.equals(p2));
        System.out.println("p.equals(p3) = " + p.equals(p3));
        //p.equals(p1) = true
        //p.equals(p2) = false
        //p.equals(p3) = true

        //System.out.println("null==null = " + null==null);//false
        //System.out.println("Objects.equals(null,null) = " + Objects.equals(null,null));//Objects.equals(null,null) = true

        boolean a = null==null;
        boolean b = Objects.equals(null,null);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        //a = true
        //b = true


        System.out.println("null==null = " + null==null);
        System.out.println("(null==null) = " + (null==null));
    }
}
