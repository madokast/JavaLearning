package zrx.com.MultiThread.Basic;

import zrx.com.MultiThread.Basic.BasicSkill.ConcurrentAccess;
import zrx.com.MultiThread.Basic.BasicSkill.HowToStopAThread;
import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.MyTimer;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/11/9 17:47
 *
 * @author zrx
 * @version 1.0
 */

public class Test {
    @org.junit.Test public void Test(){}

    @org.junit.Test public void TestConcurrentAccess(){
        ConcurrentAccess.test();
    }

    @org.junit.Test public void hardWorkTest(){
        MyTimer.runtime();
        MyTools.hardWork(1);//0.01s
        MyTimer.runtime();
        MyTimer.runtime();
        MyTools.hardWork(1);
        MyTimer.runtime();
        MyTimer.runtime();
        MyTools.hardWork(10);//0.075s
        MyTimer.runtime();
        MyTimer.runtime();
        MyTools.hardWork(10);
        MyTimer.runtime();
    }

    @org.junit.Test public void testHowToStopAThread(){
        HowToStopAThread.learn();
    }
}
