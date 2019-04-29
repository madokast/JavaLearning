package IDEAJAVALEARN.TenInterface;

/**
 * 接口 公共标准
 */
public class Test {
    public static Inter inter = new Inter() {
        @Override
        public void abstract_mathod() {
            System.out.println("abstract_mathod");
        }
    };


    public static void main(String[] args) {
        System.out.println("接口");
        inter.abstract_mathod();
        inter.default_mathod();
        Inter.static_method();
//        inter.static_method();//居然不行！
    }
}
