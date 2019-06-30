import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        change(s1,s2);
//        s2 = s1 + s2;
//        System.out.println("s2 = " + s2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        String s = "123";
        append2(s,"321");
        System.out.println(System.identityHashCode(s));
        System.out.println("s = " + s);
    }
    private static void append2(String s,String a){
        try {
            Class str = String.class;
            Field value = str.getDeclaredField("value");
            value.setAccessible(true);
            value.set(s,value.get(s+a));
        }catch (Exception e){}

    }

    private static void append(String s,String a){
        s = s+a;
    }

    private static void change(String s1, String s2) {
        s1=s2;
        s2=s1+s2;
    }
}
