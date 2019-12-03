package zrx.com.DesignPatterns;

import zrx.com.DesignPatterns.DecoratorPattern.DesignPatternsLearn;
import zrx.com.DesignPatterns.Factorys.AbstractFactoryPattern;
import zrx.com.DesignPatterns.Factorys.FactoryPattern;
import zrx.com.DesignPatterns.Factorys.SimpleFactory;
import zrx.com.DesignPatterns.ObserverPatttern.OPUser;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Description
 * DesignPatterns test
 * <p>
 * Data
 * 2019/11/22 22:59
 *
 * @author zrx
 * @version 1.0
 */

public class Test {
    @org.junit.Test
    public void testAbstractFactoryPattern(){
        AbstractFactoryPattern.go();
    }

    @org.junit.Test
    public void testFactoryPattern(){
        FactoryPattern.go();
    }

    @org.junit.Test
    public void testSimpleFactory(){
        SimpleFactory.go();
    }

    @org.junit.Test
    public void DesignPatternsLearnTest(){
        DesignPatternsLearn.go();
    }

    @org.junit.Test
    public void test2(){
        OPUser.use();
    }

    @org.junit.Test
    public void test(){
        LearnAndTest.test();
    }
}
