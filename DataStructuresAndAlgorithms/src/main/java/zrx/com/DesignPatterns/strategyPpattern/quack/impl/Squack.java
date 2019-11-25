package zrx.com.DesignPatterns.strategyPpattern.quack.impl;

import zrx.com.DesignPatterns.strategyPpattern.quack.QuackBehavior;

/**
 * Description
 * 叫法2
 * <p>
 * Data
 * 2019/11/22 22:48
 *
 * @author zrx
 * @version 1.0
 */

public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("橡皮鸭子叫");
    }
}
