package zrx.com.DesignPatterns.DecoratorPattern;

/**
 * Description
 * 基础类
 * <p>
 * Data
 * 2019/12/2 18:42
 *
 * @author zrx
 * @version 1.0
 */

public class Base implements Food{
    //空构造器
    public Base(){}

    @Override
    public String getName() {
        return "食物";
    }

    @Override
    public double getPrice() {
        return 0.5;
    }
}
