package zrx.com.DesignPatterns.DecoratorPattern;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 学习装饰设计模式
 * <p>
 * Data
 * 2019/12/2 18:42
 *
 * @author zrx
 * @version 1.0
 */

public class DesignPatternsLearn {
    public static void go(){
//        Integer.valueOf()

        MyTools.printCurrentMethod(true);
        Food food = new Base();
        food.printSelf();

        food = new Addition01(food);
        food.printSelf();

        food = new Addition02(food);
        food.printSelf();

        food = new Addition02(food);
        food.printSelf();
    }
}
