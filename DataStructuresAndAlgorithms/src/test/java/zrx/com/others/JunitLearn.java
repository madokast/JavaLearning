package zrx.com.others;

import org.junit.Test;
import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 学习junit的工作方法
 * <p>
 * Data
 * 2019/11/11 15:11
 *
 * @author zrx
 * @version 1.0
 */

public class JunitLearn {
    public static void main(String[] args) {
        new JunitLearn().test();
    }

    @Test(timeout = 1000)
    public void test(){
//        int x = 1/0;
    }
}
