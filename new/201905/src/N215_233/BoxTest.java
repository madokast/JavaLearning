package N215_233;

public class BoxTest {
    public static void main(String[] args) {
        Integer a1,a2,b1,b2,c1,c2,d1,d2;

        a1 = new Integer(4);
        a2 = new Integer(4);
        b1 = 4;
        b2 = 4;
        c1 = Integer.valueOf(4);
        c2= Integer.valueOf(4);
        d1 = Integer.valueOf(4);
        d2 = Integer.valueOf(4);

        System.out.println(System.identityHashCode(a1));
        System.out.println(System.identityHashCode(a2));
        //284720968
        //189568618

        System.out.println(System.identityHashCode(b1));
        System.out.println(System.identityHashCode(b2));
        //793589513
        //793589513

        System.out.println(System.identityHashCode(c1));
        System.out.println(System.identityHashCode(c2));
        //793589513
        //793589513
    }
}
