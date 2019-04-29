package IDEAJAVALEARN.TenPolym;

public class Test {
    public static void main(String[] args) {
        Zi zi = new Zi();
        Fu fu = new Fu();

        Fu poly = new Zi();

        System.out.println("zi.num = " + zi.num);//100
        System.out.println("fu.num = " + fu.num);//10
        System.out.println("poly.num = " + poly.num);//!!10
        //变量是没有多态的

        zi.fun();//Zi
        fu.fun();//Fu
        poly.fun();//Zi
        //方法才有多态

        zi.printnum();//100
        fu.printnum();//10
        poly.printnum();//100

        System.out.println("poly instanceof  Zi = " + (poly instanceof  Zi));
        System.out.println("poly instanceof  Fu = " + (poly instanceof  Fu));

    }
}

//public class Zi extends Fu{
//    public int num = 100;
//    @Override
//    public void fun(){
//        System.out.println("Zi");
//    }
//
//}
//public class Fu {
//    public int num = 10;
//    public void fun(){
//        System.out.println("Fu");
//    }
//}

