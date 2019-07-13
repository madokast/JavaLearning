package JunitLearn.test;

import JunitLearn.code.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {

    /**
     * 初始化方法
     * 一般用于资源的申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源的方法
     * 所用测试方法执行完后都会自动执行
     * 一定会执行，可能是在 finally 中
     */
    @After
    public void close(){
        System.out.println("closing..");
    }

    /**
     * add测试
     */
    @Test
    public void testAdd(){
//        System.out.println("不写main方法，但是被执行了");
        Calculator c= new Calculator();
        final int result = c.add(1, 2);
//        System.out.println(result);

        //断言
        Assert.assertEquals(3,result);
    }

    /**
     * 减法测试
     */
    @Test
    public void testSub(){
        Calculator c = new Calculator();
        final int sub = c.sub(3, 2);
        Assert.assertEquals(1, sub);
    }
}
