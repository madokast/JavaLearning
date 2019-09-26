package Other;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        Father f = new Son();
        // 0
    }


}

class Father{
    Father(){
        fun();
    }

    void fun(){}
}

class Son extends Father{
    private int a = 10 ;
    Son(){}

    void fun(){
        System.out.println(a);
    }
}
