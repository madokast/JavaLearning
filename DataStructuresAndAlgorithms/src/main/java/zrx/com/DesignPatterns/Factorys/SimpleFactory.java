package zrx.com.DesignPatterns.Factorys;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 简单工厂
 * <p>
 * Data
 * 2019/12/2 19:29
 *
 * @author zrx
 * @version 1.0
 */

public class SimpleFactory {
    public static void go(){
        MyTools.printCurrentMethod(true);
        System.err.println("简单工厂");

        final Production production = Factory.create();
        System.out.println("production = " + production);

        final Production production1 = Factory.create("简单");
        System.out.println("production1 = " + production1);
    }

    private class Production{
        String name;
        public Production(){
            name = "无参产品";
        }
        public Production(String name){
            this.name = name + "的产品";
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static class Factory{
        public static Production create(){
            return new SimpleFactory().new Production();
        }

        public static Production create(String name){
            return new SimpleFactory().new Production(name);
        }
    }
}
