package JunitLearn.code;

/**
 * 传统测试
 * 这样做的缺点
 * 不方便
 */

public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();

        //call
        System.out.println(c.add(1, 2));

        System.out.println(c.sub(1, 1));

    }
}
