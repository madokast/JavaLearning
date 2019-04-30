package IDEAJAVALEARN.ElevenFinal;

public class Test {
    public static void main(String[] args) {
        Inner inner = new Inner();
        System.out.println("inner.a = " + inner.a);

        Inner.A innerA = new Inner().new A();
        innerA.fun();

        Inner.A innerA2 = inner.new A();

        Inner.AAA aaa = new Inner.AAA();
        aaa.funAAA();

    }
}
