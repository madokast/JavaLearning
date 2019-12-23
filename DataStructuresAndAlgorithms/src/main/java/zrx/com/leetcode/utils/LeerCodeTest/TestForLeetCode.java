package zrx.com.leetcode.utils.LeerCodeTest;


import zrx.com.leetcode.utils.MyTimer;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description
 * leetcode测试器
 * <p>
 * Data
 * 2019/11/10 16:14
 *
 * @author zrx
 * @version 1.0
 */

public class TestForLeetCode {
    public static void happyTimeLimit(Question q, int maxSecond) {
        //使用future重写
        Callable<?> callable = () -> {
            happy(q);
            return null;//不需要返回值
        };

        FutureTask<?> futureTask = new FutureTask<>(callable);

        Thread runTheTest = new Thread(futureTask);
        runTheTest.setDaemon(true);//神来之笔
        runTheTest.start();

        try {
            //核心代码
            futureTask.get(maxSecond, TimeUnit.SECONDS);
        }catch (TimeoutException te){
            System.err.println("计算超时"+"["+maxSecond+"s]"+"："+q.getQuestionName());
        }
        catch (Exception e){
            System.err.println("TestForLeetCode happyTimeLimit未知错误");
            e.printStackTrace();
        }


//        Thread mainThread = Thread.currentThread();
//        Thread thread = new Thread(()->{
//            happy(q);
//            mainThread.interrupt();
//        });
//        thread.start();
//        try {
//            thread.join(maxSecond*1000);
//        }catch (InterruptedException e){
//            return;
//        }
//
//        System.err.println("计算超时"+"["+maxSecond+"s]"+"："+q.getQuestionName());
//        try {
//            thread.stop();
//        }catch (ThreadDeath e){
//            return;
//        }
    }

    public static void happy(Question q) {
        MyTimer.runtimeBack();

        final List<Input[]> inputsList = q.getInputsList();
        final List<Answer> answerList = q.getAnswers();
        final TestEntry entry = q.getTestEntry();
        final String questionName = q.getQuestionName();


        System.out.println("------ 开始测试" + questionName + " ----------------");
        if (inputsList.size() != answerList.size()) {
            System.err.println(questionName + "；输入和答案个数不统一");
        }

        int times = inputsList.size();
        if (times <= 0) {
            System.err.println(questionName + "；没有测试数据，测试停止");
            return;
        }

        for (int i = 0; i < times; i++) {
            System.out.println("***测试第" + (i + 1) + "组");
            try {
                oneByOne(q, entry, inputsList.get(i), answerList.get(i));
            } catch (Exception e) {
                System.err.println("测试中出现异常，测试中断");
                e.printStackTrace();
                return;
            }
            System.out.println("***第" + (i + 1) + "组测试完毕");
        }

        final long runtimeBack = MyTimer.runtimeBack();
        System.out.println("------ " + questionName + " 测试完毕，用时" + runtimeBack + "ms ------\n\n");
    }

    private static void oneByOne(Question q, TestEntry entry, Input[] inputs, Answer answer) throws Exception {
        final Class<?> solutionClass = entry.getSolution().getClass();
        final Method testMethod = solutionClass.getMethod(entry.getMethodName(), entry.getParameters());
        final int[] reprintInputs = q.reprintInputs();

        //制作输入
        Object[] testMethodInput = new Object[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            testMethodInput[i] = inputs[i].getValue();
        }
        System.out.println("输入：" + Printer.print(testMethodInput)); // 必须此时调用

        if (reprintInputs.length != 0) {
            for (int reprintInput : reprintInputs) {
                String parameterName = testMethod.getParameters()[reprintInput].getName();
                System.out.println("形参(" + parameterName + ")执行前：" + Printer.print(inputs[reprintInput].getClazz(),
                        inputs[reprintInput].getValue()));
            }
        }

        //执行测试方法
        Object ret = null;
        try {
            ret = testMethod.invoke(entry.getSolution(), testMethodInput);
        } catch (InvocationTargetException e) {
            // 测试超时引发
            return;
        }

//        System.out.println("输入：" + Printer.print(testMethodInput));
        System.out.println("输出：" + Printer.print(answer.getClazz(), ret));
        System.out.println("答案：" + Printer.print(answer.getClazz(), answer.getValue()));

        if (reprintInputs.length != 0) {
            for (int reprintInput : reprintInputs) {
                String parameterName = testMethod.getParameters()[reprintInput].getName();
                System.out.println("形参(" + parameterName + ")执行后：" + Printer.print(inputs[reprintInput].getClazz(),
                        inputs[reprintInput].getValue()));
            }
        }

        final boolean judge = EqualJudge.judge(answer.getClazz(), ret, answer.getValue());
        if (judge) {
            System.out.println("输出正确");
        } else {
            System.err.println("输出错误");
        }
    }


    public static void happy(Class<? extends Question> klass){
        try {
            happy(klass.getConstructor().newInstance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
