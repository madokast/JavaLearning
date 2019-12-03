package zrx.com.DesignPatterns.DecoratorPattern;

/**
 * Description
 * 添加剂二
 * <p>
 * Data
 * 2019/12/2 18:47
 *
 * @author zrx
 * @version 1.0
 */

public class Addition02 implements Food{
    private Food food;

    public Addition02(Food food) {
        this.food = food;
    }

    @Override
    public String getName() {
        return food.getName()+"-添加剂2";
    }

    @Override
    public double getPrice() {
        return food.getPrice()+2.0;
    }
}
