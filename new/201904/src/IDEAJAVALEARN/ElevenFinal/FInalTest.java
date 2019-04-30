package IDEAJAVALEARN.ElevenFinal;

public class FInalTest {
    public static final int NUM  = 10;

    public static void main(String[] args) {
        System.out.println("hello");
        final int a = 100;
        System.out.println("a = " + a);
//        a = 20;

        System.out.println(NUM);
    }

    static class Ne{}


}

//final class Fu{ }

//class Zi extends Fu{}

class Fu{
    public final void fun(){}
}

class Zi extends Fu{
//    public void fun(){}
}