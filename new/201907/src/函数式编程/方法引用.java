package 函数式编程;

public class 方法引用 {
    public static void main(String[] args) {
        printString(方法引用::printTwice);
        printString(new 方法引用()::print3);

        printString(new Son()::print3);
    }

    public static void printString(Printable p){
        p.print("hello");
    }

    public static void printTwice(String s){
        System.out.println(s+s);
    }

    public void print3(String s){
        System.out.println(s+s+s);
    }
}
