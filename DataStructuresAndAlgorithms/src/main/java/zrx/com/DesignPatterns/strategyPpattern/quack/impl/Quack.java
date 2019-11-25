package zrx.com.DesignPatterns.strategyPpattern.quack.impl;

import zrx.com.DesignPatterns.strategyPpattern.quack.QuackBehavior;

/**
 * Description
 * 叫法1
 * <p>
 * Data
 * 2019/11/22 22:48
 *
 * @author zrx
 * @version 1.0
 */

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子叫");
    }
}
