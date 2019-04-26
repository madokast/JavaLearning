package Test;

import java.util.Objects;

public class InterDemo2 {
    public static void main(String[] args) {
        //接口中写了boolean equals(Object o);
        //说明一定要重写它
        InterTest2 interTest2 = new InterTest2() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
