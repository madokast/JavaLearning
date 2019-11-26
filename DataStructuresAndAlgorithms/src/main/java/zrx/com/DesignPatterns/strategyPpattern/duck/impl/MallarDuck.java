package zrx.com.DesignPatterns.strategyPpattern.duck.impl;

import zrx.com.DesignPatterns.strategyPpattern.duck.AbstractDuck;
import zrx.com.DesignPatterns.strategyPpattern.duck.Duck;
import zrx.com.DesignPatterns.strategyPpattern.fly.impl.FlyWithWings;
import zrx.com.DesignPatterns.strategyPpattern.quack.impl.Quack;

/**
 * Description
 * 鸭子
 * <p>
 * Data
 * 2019/11/22 22:53
 *
 * @author zrx
 * @version 1.0
 */

public class MallarDuck extends AbstractDuck implements Duck {
    public MallarDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void swim() {
        System.out.println("绿色鸭子游泳");
    }

    @Override
    public void display() {
        System.out.println("是绿色鸭子");
    }
}
