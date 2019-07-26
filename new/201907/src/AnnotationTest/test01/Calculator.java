package AnnotationTest.test01;

/**
 * 小明定义的计算器类
 * 466
 */

public class Calculator {
    //add
    @Check
    public void add(){
        System.out.println("(1+0) = " + (1 + 0));
    }

    //sub
    @Check
    public void sub(){
        System.out.println("(1-0) = " + (1 - 0));
    }

    //mul
    @Check
    public void mul(){
        System.out.println("(1*0) = " + (1 * 0));
    }

    //div
    @Check
    public void div(){
        System.out.println("(1/0) = " + (1 / 0));
    }

    //sqrt
    @Check
    public void sqrt(){
        System.out.println("Math.sqrt(-1) = " + (int)Math.sqrt(-1));
    }

    public void show(){
        System.out.println("永无bug...");
    }
}
