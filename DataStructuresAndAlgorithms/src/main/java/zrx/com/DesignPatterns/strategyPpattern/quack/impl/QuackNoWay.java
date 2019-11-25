package zrx.com.DesignPatterns.strategyPpattern.quack.impl;

import zrx.com.DesignPatterns.strategyPpattern.quack.QuackBehavior;

/**
 * Description
 * 不叫
 * <p>
 * Data
 * 2019/11/22 22:49
 *
 * @author zrx
 * @version 1.0
 */

public class QuackNoWay implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
