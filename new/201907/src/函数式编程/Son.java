package 函数式编程;

public class Son extends 方法引用 {
    @Override
    public void print3(String s){
        System.out.println(s+3);
    }

    public void test(){
        方法引用.printString(this::print3);
        方法引用.printString(super::print3);
//        方法引用.printString(class::print4);
    }

    public static void print4(String s){
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        new Son().test();


    }
}
