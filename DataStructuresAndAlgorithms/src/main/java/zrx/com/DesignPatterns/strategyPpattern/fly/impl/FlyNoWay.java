package zrx.com.DesignPatterns.strategyPpattern.fly.impl;

import zrx.com.DesignPatterns.strategyPpattern.fly.FlyBehavior;

/**
 * Description
 * 飞行方法二
 * <p>
 * Data
 * 2019/11/22 22:47
 *
 * @author zrx
 * @version 1.0
 */

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞行");
    }
}
