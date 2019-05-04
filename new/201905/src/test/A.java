package test;

//抽象类AA实现了接口IA
public class A extends AA implements IA{
    public static void main(String[] args) {
        A a = new A();
        a.func();
    }
}
