package zrx.com.DesignPatterns.DecoratorPattern;

/**
 * Description
 * 添加剂
 * <p>
 * Data
 * 2019/12/2 18:46
 *
 * @author zrx
 * @version 1.0
 */

public class Addition01 implements Food{
    private Food food;

    public Addition01(Food food) {
        this.food = food;
    }

    @Override
    public String getName() {
        return food.getName()+"-添加剂1";
    }

    @Override
    public double getPrice() {
        return food.getPrice()+1.0;
    }
}
