package IDEAJAVALEARN.ElevenFinal;

import java.lang.reflect.Field;

public class LocalClass2
{
    public void fun()
    throws Exception
    {
        final Integer a = 10;
        class LC{public void printA(){
            System.out.println("a = " + a);
        }}
        LC lc = new LC();
        lc.printA();
        System.out.println("---------------");

        Class c = a.getClass();
        Field f = c.getDeclaredField("value");
        f.setAccessible(true);
        f.setInt(a,20);
        lc.printA();

        System.out.println("---------------------");

        B b = ()-> System.out.println(2*a);
        b.fun();
        f.set(a,233333);
        b.fun();



    }

    public static void main(String[] args)
    throws Exception
    {
        new LocalClass2().fun();
    }
}

interface B{void fun();}
