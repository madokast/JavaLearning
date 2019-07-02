package 函数式编程;

/**
 * lambda 好处都有啥？
 * 懒执行
 */

public class LoggerTest {
    public static void main(String[] args) {
        //旧发放
        showMsg(1,"123"+"312"+"abc");
        showMsg(2,"123"+"312"+"abc");

        System.out.println("----------------------");

        //新方法 不会存在性能浪费
        showMsg(1,()->"123"+"312"+"abc");
        showMsg(2,()->{
            try {
                Thread.currentThread().sleep(10000);
            }catch (Exception e){}
            return "123";
        });
    }

    /**
     * 存在的问题——性能浪费
     * 传递的第二个参数很可能没用，很多时候不需要传递 。 尤其是字符串是拼接的时候
     *  白拼接了
     * 可以利用lambda优化
     * @param level 日志等级 只有等级 1 的才会输出
     * @param mas 日志信息
     */
    public static void showMsg(int level,String mas){
        //如果日志等级是1 则输出日志信息
        if(level==1)
            System.out.println(mas);
    }

    /**
     * 优化后的方法
     * @param level 同上 日志等级 只有等级 1 的才会输出
     * @param m 构建 日志信息 的函数式接口
     */
    public static void showMsg(int level,MessageBuilder m){
        if(level==1)
            System.out.println(m.builderMessage());
    }
}
