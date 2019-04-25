package madokasr;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMain {

    public static void test1(){
        Apple<Float> a1 = new Apple<>((float)0.1);
        Apple<Double> a2 = new Apple<>(0.1);

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);

        System.out.println(a1.getClass());
        System.out.println(a2.getClass());
        //class madokasr.Apple
        //class madokasr.Apple

        Integer i = 10;
        Float f = (float)0.1;
        System.out.println(i instanceof Number);
        System.out.println(f instanceof Number);
        //true
        //true

        /*
        Integer[] iarr = {1,2,3};
        Number[] narr = iarr;
        //narr[0]=(float)0.5;
        System.out.println("narr = " + narr);
        //Exception in thread "main" java.lang.ArrayStoreException: java.lang.Float
        //	at madokasr.GenericMain.main(GenericMain.java:27)
        */

        System.out.println("***********************");
        ArrayList<Integer> alint = new ArrayList<>();
        alint.add(1);
        alint.add(2);
        alint.add(3);
        alint.add(4);
        ArrayList<String> alstr = new ArrayList<>();
        alstr.add("123");
        alstr.add("anda");
        alstr.add("asx3");
        alstr.add("12");
        System.out.println("alint = " + alint);
        System.out.println("alstr = " + alstr);
        //alint = [1, 2, 3, 4]
        //alstr = [123, anda, asx3, 12]

        PrintList.printList(alint);
        //1
        //2
        //3
        //4

        //PrintList.printList(alstr);
        //wrong!
        System.out.println("***********************");

        Apple a = new Apple();
        a.setWeight(3.14);
        System.out.println("a = " + a);
        //a = Apple{weight=3.14}
    }


    public static void main(String[] args) {
        test1();

        System.out.println("****************");
        ArrayList<String> als = new ArrayList<>();
        als.add("qwe");
        als.add("123");
        System.out.println("als = " + als);
        OnlyForList.listList(als);
        //qwe
        //123

        //OnlyForList.objectList(als);
        //Error:(81, 32) java: 不兼容的类型: java.util.ArrayList<java.lang.String>无法转换为java.util.List<java.lang.Object>

        OnlyForList.astikList(als);
        //qwe
        //123

        String[] arrs = {"12","ac","de"};
        Collection<String> als2 =new ArrayList<>() ;
        //GenericMethod.arrayToCollectionObject(arrs,als2);
        //wrong

        GenericMethod.arrayToCollectionT(arrs,als2);
        System.out.println("als2 = " + als2);
        //als2 = [12, ac, de]

        GenericConstructor gc = new GenericConstructor(12);
        GenericConstructor gc1 = new GenericConstructor("ac");
        GenericConstructor gc2 = new <Double> GenericConstructor(12.3);
        GenericConstructor gc3 = new GenericConstructor("wec");
        //12
        //ac
        //12.3
        //wec

        Superclass supc= new Superclass();
        Sonclass sonc = new Sonclass();
        ArrayList al3 = new ArrayList();
        al3.add(supc);
        al3.add(sonc);




    }

    
}

class Apple<T extends Number>{
    private T weight;
    public Apple(T weight){
        this.weight=weight;
    }

    public Apple(){
        this.weight=null;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }
}

//can only print array list with class extending number class
class PrintList{
    public static void printList(ArrayList<? extends Number> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

class OnlyForList {
    public static void listList(List c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

    public static void objectList(List<Object> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

    public static void astikList(List<?> c){
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

}

class GenericMethod{
    public static void arrayToCollectionObject(Object[] os, Collection<Object> cs){
        for(Object o:os){
            cs.add(o);
        }
    }

    public static  <T>  void arrayToCollectionT(T[] os,Collection<T> cs){
        for(T o:os){
            cs.add(o);
        }
    }
}

class GenericConstructor{
    public <T> GenericConstructor(T t){
        System.out.println(t);
    }
}

class Superclass{}

class Sonclass extends Superclass{}
