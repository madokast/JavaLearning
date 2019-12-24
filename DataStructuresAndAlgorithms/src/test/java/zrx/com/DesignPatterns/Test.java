package zrx.com.DesignPatterns;

import zrx.com.DesignPatterns.CommandPattern.Remoter;
import zrx.com.DesignPatterns.CommandPattern.command.MetaCommand;
import zrx.com.DesignPatterns.DecoratorPattern.DesignPatternsLearn;
import zrx.com.DesignPatterns.Factorys.AbstractFactoryPattern;
import zrx.com.DesignPatterns.Factorys.FactoryPattern;
import zrx.com.DesignPatterns.Factorys.SimpleFactory;
import zrx.com.DesignPatterns.ObserverPatttern.OPUser;
import zrx.com.DesignPatterns.strategyPpattern.LearnAndTest;
import zrx.com.MultiThread.MyTools;

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
    public void testCommandPattern(){
        MyTools.printCurrentMethod(true,"学习命令模式");

        MyTools.printMsgWithThreadAndTime("#######一顿操作猛如虎#######");


        final Remoter remoter = new Remoter();

        remoter.tvOn();
        remoter.lightOn();
        remoter.TVVolumeUp();
        remoter.TVVolumeUp();
        remoter.lightColor();
        remoter.TVVolumeUp();
        remoter.lightColor();

        MyTools.printMsgWithThreadAndTime("#######全部取消都没了#######");

        for (int i = 0; i < 10; i++) {
            remoter.undo();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        MyTools.printMsgWithThreadAndTime("#######轻松点击宏按钮#######");

        MetaCommand metaCommand = new MetaCommand();
        metaCommand.execute();
        MyTools.printMsgWithThreadAndTime("#######轻松点击宏取消#######");
        metaCommand.undo();

    }

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
