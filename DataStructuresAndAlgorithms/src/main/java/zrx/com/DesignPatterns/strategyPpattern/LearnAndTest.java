package zrx.com.DesignPatterns.strategyPpattern;

import zrx.com.DesignPatterns.strategyPpattern.duck.AbstractDuck;
import zrx.com.DesignPatterns.strategyPpattern.duck.impl.MallarDuck;

/**
 * Description
 * 学习笔记
 *
 * 策略设计模式 strategy pattern
 *
 * <p>
 * Data
 * 2019/11/22 22:42
 *
 * @author zrx
 * @version 1.0
 */

public class LearnAndTest {
    public static void test(){
        strategyPattern();
    }

    private static void strategyPattern() {
        System.err.println("-------strategyPattern--------");


        AbstractDuck duck = new MallarDuck();
        System.err.println("new了一个绿色鸭子");
        duck.performFly();
        duck.performQuack();
        duck.swim();
        duck.display();
    }


}
