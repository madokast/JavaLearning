package IDEAJAVALEARN.TenInterface;

public interface Inter {
    void abstract_mathod();

    public default void default_mathod(){
        System.out.println("default_mathod");
        private_method();
    }

    public static void static_method(){
        System.out.println("接口中的静态方法");
    }

    private void private_method(){
        System.out.println("private_method");
    }
}
