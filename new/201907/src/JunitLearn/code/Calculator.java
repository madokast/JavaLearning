package JunitLearn.code;

/**
 * 450
 * Junit 单元测试
 * 反射 后期框架设计的灵魂
 * 注解
 *
 * 451
 * Junit 单元测试
 *  1.黑盒测试
 *  2.白盒测试。需要写代码，需要关注代码具体的执行过程
 *      Junit测试就是白盒测试的一种
 *
 * 452
 * 第一步：定义测试用例/就是一个类
 *    建议：
 *      类名：叫做 被测试类名+test01
 *      包名：xxx.xxx.xxx.test下
 * 第二步：定义测试方法：可以独立运行
 *    建议：方法名，text+被方法名  ： testAdd
 *          返回值 void
 *          参数列表：空参数
 * 第三步：给方法加上@Test注解，就能独立运行了
 *  不需要自己写main方法
 * 绿色代码成功
 * 红色代码失败
 */

public class Calculator {
    /**
     * 加法
     * @param a 数a
     * @param b 数b
     * @return 和
     */
    public int add(int a,int b){
//        int i = 3/0;
        return a+b;
    }

    /**
     * 减法
     * @param a 被减数
     * @param b 减数
     * @return 差
     */
    public int sub(int a,int b){
        return a-b;
    }
}
