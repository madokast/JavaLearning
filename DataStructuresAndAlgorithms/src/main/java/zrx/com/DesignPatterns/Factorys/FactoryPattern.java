package zrx.com.DesignPatterns.Factorys;

import zrx.com.MultiThread.MyTools;
import zrx.com.leetcode.utils.LeerCodeTest.ToString;

/**
 * Description
 * 工厂模式
 * <p>
 * Data
 * 2019/12/2 19:36
 *
 * @author zrx
 * @version 1.0
 */

public class FactoryPattern {

    public static void go(){
        MyTools.printCurrentMethod(true);
        System.err.println("工厂模式");

        Factory factory1 = new FactoryPattern().new ConcreteFactory1();
        Factory factory2 = new FactoryPattern().new ConcreteFactory2();

        final Production production1 = factory1.create();
        final Production production2 = factory2.create();

        System.out.println("production1 = " + production1);
        System.out.println("production2 = " + production2);

    }

    //具体工厂2
    class ConcreteFactory2 implements Factory{
        @Override
        public Production create() {
            return new FactoryPattern().new ConcreteProdction2();
        }
    }

    //具体工厂1
    class ConcreteFactory1 implements Factory{
        @Override
        public Production create() {
            return new FactoryPattern().new ConcreteProdction1();
        }
    }

    //抽象工厂
    interface Factory{
        Production create();
    }

    //具体产品
    class ConcreteProdction2 implements Production{
        @Override
        public String getName() {
            return "产品2";
        }
        @Override
        public String toString(){
            return getName();
        }
    }

    //具体产品
    class ConcreteProdction1 implements Production{
        @Override
        public String getName() {
            return "产品1";
        }
        @Override
        public String toString(){
            return getName();
        }
    }

    //抽象产品
    interface Production{
        String getName();
    }
}
