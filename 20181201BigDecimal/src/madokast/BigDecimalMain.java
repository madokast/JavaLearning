package madokast;

import java.math.BigDecimal;

public class BigDecimalMain {
    public static void main(String[] args) {
        /*借用《Effactive Java》这本书中的话，float和double类型的主要设计目标是为了科学计算和工程计算。
        他们执行二进制浮点运算，这是为了在广域数值范围上提供较为精确的快速近似计算而精心设计的。
        然而，它们没有提供完全精确的结果，所以不应该被用于要求精确结果的场合。
        但是，商业计算往往要求结果精确，这时候BigDecimal就派上大用场啦。
---------------------
          作者：jackiehff
          来源：CSDN
          原文：https://blog.csdn.net/jackiehff/article/details/8582449
          版权声明：本文为博主原创文章，转载请附上博文链接！
        * */


        //out 0.060000000000000005
        System.out.println(0.05 + 0.01);

        //use BigDecimal class and out is 0.06
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));

        //use double to initialize BigDecimal
        //however it outs 0.06000000000000000298372437868010820238851010799407958984375
        //so it better doesn't use double variables to initialize BigDecimal
        b1 = new BigDecimal(0.05);
        b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));

        //if i only have a double variable
        //change it to String and then use the String to initialize the BigDecimal
        double d1 = 1. / 3.;
        b1 = new BigDecimal(d1);
        b2 = new BigDecimal(String.valueOf(d1));
        System.out.println(b1);//0.333333333333333314829616256247390992939472198486328125
        System.out.println(b2);//0.3333333333333333

        BigDecimal b3=b1.add(b2);
        System.out.println("b1 = " + b1);//b1 = 0.333333333333333314829616256247390992939472198486328125
        b1 = b1.add(b2);
        System.out.println("b1 = " + b1);//b1 = 0.666666666666666614829616256247390992939472198486328125
    }
}
