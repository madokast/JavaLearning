package Test;

import java.util.Collection;

public class InterDemo {
    public static void main(String[] args) {

        //找到接口中的静态常量a
        System.out.println("interTestADD.a = " + interTestADD.a);
        System.out.println("interTestSUB.a = " + interTestSUB.a);
        System.out.println("InterTest.a = " + InterTest.a);
        //interTestADD.a = 10
        //interTestSUB.a = 10
        //InterTest.a = 10

        //接口中的一般方法
        System.out.println("interTestADD.operation(3,4) = " + interTestADD.operation(3,4));
        System.out.println("interTestSUB.operation(3,4) = " + interTestSUB.operation(3,4));
        //interTestADD.operation(3,4) = 7
        //interTestSUB.operation(3,4) = -1


        //接口中的default方法
        interTestADD.defaultMathod();
        interTestSUB.defaultMathod();
        //defaultMathod in interface
        //defaultMathod in interface

        //重写default方法
        interTestOVR.defaultMathod();
        //重写default方法

        //谁写成这样，要打人
        System.out.println(((InterTest)(a,b)->a*b).operation(3,4));



    }

    public static InterTest interTestADD = new InterTest() {
        @Override
        public int operation(int a, int b) {
            return a+b;
        }
    };

    public static InterTest interTestSUB = new InterTest() {
        @Override
        public int operation(int a, int b) {
            return a-b;
        }
    };

    public static InterTest interTestOVR = new InterTest() {
        @Override
        public int operation(int a, int b) {
            return 0;
        }

        @Override
        public void defaultMathod(){
            System.out.println("重写default方法");
        }
    };
}
