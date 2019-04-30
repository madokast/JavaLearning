package IDEAJAVALEARN.ElevenFinal;

public class Inner {
    public class A{
        public void fun(){
            int a = 12;
            System.out.println(a);
            System.out.println("Inner.this.a = " + Inner.this.a);

//            fun();

            Inner.this.fun();
        }
    }
    public int a = 10;

    public void fun(){
        System.out.println("outer");
    }

    public static class AAA{
        public void funAAA(){
            System.out.println(aaa);
        }
    }

    public static int aaa=1000;
}