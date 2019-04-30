package IDEAJAVALEARN.ElevenFinal;

import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args)
    throws Exception
    {
        LocalClass localClass  = new LocalClass();
        localClass.fun();
        localClass.fun2();

        Object ob = localClass.fun3();
        System.out.println(ob);
        System.out.println(ob.getClass());
        Class A3 = ob.getClass();
        Field[] fields = A3.getFields();
        System.out.println("len= "+fields.length);
        for (Field f:fields
             ) {
            System.out.println(f);
        }
//        field.setInt(ob,23333);
        System.out.println(ob);
    }
}
