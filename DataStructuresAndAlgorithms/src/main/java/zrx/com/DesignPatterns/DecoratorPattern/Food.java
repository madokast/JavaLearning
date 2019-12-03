package zrx.com.DesignPatterns.DecoratorPattern;

/**
 * 食物接口
 */
public interface Food {
    String getName();

    double getPrice();

    default void printSelf() {
        System.out.println("这是" + getName() + ",价格是" + getPrice());
    }
}
