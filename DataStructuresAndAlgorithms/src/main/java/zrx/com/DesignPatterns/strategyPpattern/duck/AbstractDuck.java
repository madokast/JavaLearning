package zrx.com.DesignPatterns.strategyPpattern.duck;

import zrx.com.DesignPatterns.strategyPpattern.fly.FlyBehavior;
import zrx.com.DesignPatterns.strategyPpattern.quack.QuackBehavior;

/**
 * Description
 * 鸭子类
 * <p>
 * Data
 * 2019/11/22 22:51
 *
 * @author zrx
 * @version 1.0
 */

public abstract class AbstractDuck implements Duck{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
}
