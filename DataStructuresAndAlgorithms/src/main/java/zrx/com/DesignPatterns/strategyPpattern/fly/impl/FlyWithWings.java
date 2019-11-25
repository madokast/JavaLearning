package zrx.com.DesignPatterns.strategyPpattern.fly.impl;

import zrx.com.DesignPatterns.strategyPpattern.fly.FlyBehavior;

/**
 * Description
 * 飞行方法一
 * <p>
 * Data
 * 2019/11/22 22:46
 *
 * @author zrx
 * @version 1.0
 */

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("翅膀飞行");
    }
}
