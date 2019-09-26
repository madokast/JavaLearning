package Other;


public class Test1 {
    public static void main(String[] args) throws Exception {
        A a = new A();
        A a1 = (A)a.clone();

        System.out.println("a = " + a);
        System.out.println("a1 = " + a1);

        ThreadLocal threadLocal;

    }


}

class A implements Cloneable{
    private int i;

    A(){
        i = 10;
        System.out.println("aaaaaaaaaaaaaaa");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
