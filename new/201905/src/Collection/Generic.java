package Collection;

import java.util.Collection;

public class Generic <E> {
    E e;
    Generic(E e){this.e=e;}

    public <E> E getE(){return (E)e;}

    @Override
    public String toString(){
        return e.getClass() +"@"+ e.toString();
    }

    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<>(123);
        Generic<String> generic1 = new Generic<>("abc");

        System.out.println("generic1 = " + generic1);
        System.out.println("generic = " + generic);
        //generic1 = class java.lang.String@abc
        //generic = class java.lang.Integer@123

        System.out.println("--------------------------");

        System.out.println(generic.getClass());
        System.out.println(generic1.getClass());
        //class Collection.Generic
        //class Collection.Generic

        System.out.println("--------------------------");
        for(Object o :generic.getClass().getGenericInterfaces()){
            System.out.println(o);
        }
        System.out.println("--------------------------");
        System.out.println("generic.getE() = " + generic.getE());
        System.out.println("generic1.getE() = " + generic1.getE());
        //generic.getE() = 123
        //generic1.getE() = abc
    }

    public void test(Collection<?> c){

    }
}
