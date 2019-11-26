package zrx.com.DesignPatterns;

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
    public void test2(){
        OPUser.use();
    }

    @org.junit.Test
    public void test(){
        LearnAndTest.test();
    }
}
