package Test;

import java.util.Objects;

public class InterDemo2 {
    public static void main(String[] args) {
        //接口中写了boolean equals(Object o);
        //说明一定要重写它
        InterTest2 interTest2 = new InterTest2() {};
        System.out.println("interTest2 = " + interTest2);
        System.out.println("interTest2.equals(\"qwe\") = " + interTest2.equals("qwe"));
        System.out.println("interTest2.equals((Objects)interTest2) = " + interTest2.equals(interTest2));

        Object o12 = (Object) "213";
        Object p23 = "123";
        Object o233 = interTest2;

        Object o11 = String.class;
    }
}
