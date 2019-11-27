package zrx.com.others.Symblic;

import org.junit.Assert;
import zrx.com.others.Symbolics.*;

import java.io.File;
import java.io.FileWriter;

@SuppressWarnings("all")
public class Test {
//    @org.junit.Test
    public void T126() throws Exception {
        final Vector x0 = Vector.create("x0_", 6);
        final Matrix2 r10 = Matrix2.create("R10_", 6);
        final Matrix3 t10 = Matrix3.create("T10_", 6);

        Vector x1 = Vector.add(Matrix2.multiply(r10, x0), Matrix3.multiplyHalf(t10, x0, x0), "x1");
//        System.err.println(x1);

        final Expression x1_1 = x1.get(1);
        System.out.println("x1_1.size() = " + x1_1.size());

        final Matrix2 r21 = Matrix2.create("R21_", 6);
        final Matrix3 t21 = Matrix3.create("T21_", 6);

        Vector x2 = Vector.add(Matrix2.multiply(r21, x1), Matrix3.multiplyHalf(t21, x1, x1), "x2");
//        System.err.println(x2);

        final Expression x2_1 = x2.get(1);
        System.out.println("x2_1.size() = " + x2_1.size());


        final Expression t126xx = x2_1
                .subExpression(new Factor("x0_6"))
                .subExpression(new Factor("x0_2"))
                .subExpressionOut(new Factor("x0_1"))
                .subExpressionOut(new Factor("x0_3"))
                .subExpressionOut(new Factor("x0_4"))
                .subExpressionOut(new Factor("x0_5"));
        System.err.println(t126xx.isEmpty());

        System.err.println(t126xx);

        for (String s : t126xx.toString().split("\\+")) {
            final String[] strings = s.split("\\*");
            for (String string : strings) {
                if (string.charAt(0) != 'x') {
                    System.err.print(string + "  ");
                }
            }
            System.err.println();
        }


        final FileWriter fileWriter = new FileWriter(new File("t126.txt"));
        fileWriter.write(x2_1.toString());
        fileWriter.close();
    }

//    @org.junit.Test
    public void split(){
        String ss = "r21_11*t10_126 + r21_12*t10_226 + r21_13*t10_326 + r21_14*t10_426 + r21_15*t10_526 + r21_16*t10_626 + 2*r10_12*r10_16*t21_111 + r10_12*r10_26*t21_112 + r10_16*r10_22*t21_112 + r10_12*r10_36*t21_113 + r10_16*r10_32*t21_113 + 2*r10_22*r10_26*t21_122 + r10_12*r10_46*t21_114 + r10_16*r10_42*t21_114 + r10_22*r10_36*t21_123 + r10_26*r10_32*t21_123 + r10_12*r10_56*t21_115 + r10_16*r10_52*t21_115 + r10_22*r10_46*t21_124 + r10_26*r10_42*t21_124 + r10_12*r10_66*t21_116 + r10_16*r10_62*t21_116 + 2*r10_32*r10_36*t21_133 + r10_22*r10_56*t21_125 + r10_26*r10_52*t21_125 + r10_32*r10_46*t21_134 + r10_36*r10_42*t21_134 + r10_22*r10_66*t21_126 + r10_26*r10_62*t21_126 + r10_32*r10_56*t21_135 + r10_36*r10_52*t21_135 + 2*r10_42*r10_46*t21_144 + r10_32*r10_66*t21_136 + r10_36*r10_62*t21_136 + r10_42*r10_56*t21_145 + r10_46*r10_52*t21_145 + r10_42*r10_66*t21_146 + r10_46*r10_62*t21_146 + 2*r10_52*r10_56*t21_155 + r10_52*r10_66*t21_156 + r10_56*r10_62*t21_156 + 2*r10_62*r10_66*t21_166";
        for (String s : ss.split("\\+")) {
            final String[] strings = s.split("\\*");
            for (String string : strings) {
                if (string.charAt(0) != 'x') {
                    System.err.print(string + "  ");
                }
            }
            System.err.println();
        }
    }

//    @org.junit.Test
    public void matlabEval() throws Exception {
        //eval('syms MyTools ;')

        StringBuilder sb = new StringBuilder();

        //x0_i
        for (int i = 1; i <= 6; i++) {
            sb.append("eval('syms ");
            sb.append("x0_" + i);
            sb.append(" ;')\n");
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                sb.append("eval('syms ");
                sb.append("R10_" + i + j);
                sb.append(" ;')\n");
                sb.append("eval('syms ");
                sb.append("R21_" + i + j);
                sb.append(" ;')\n");
            }
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    sb.append("eval('syms ");
                    sb.append("T10_" + i + j + k);
                    sb.append(" ;')\n");
                    sb.append("eval('syms ");
                    sb.append("T21_" + i + j + k);
                    sb.append(" ;')\n");
                }
            }
        }

        final FileWriter fileWriter = new FileWriter(new File("matlabEval.txt"));
        fileWriter.write(sb.toString());
        fileWriter.close();

        System.err.println("finished");
//        new File("matlabEval.txt").delete();
    }

    /**
     * importance
     * @throws Exception
     */
//    @org.junit.Test
    public void matlabEval2() throws Exception {
        StringBuilder sb = new StringBuilder();
        int len = 6;

        sb.append("eval('syms ");
        sb.append("x0 x1 x2 R10 R21 T10 T21");
        sb.append(" ;')\n");

        for (int i = 1; i <= len; i++) {
            sb.append("eval('syms ");
            sb.append("x0_" + i);
            sb.append(" ;')\n");

            sb.append("x0(" + i + ",1" + ")" + " = x0_" + i + ";\n");
        }

        for (int i = 1; i <= len; i++) {
            sb.append("eval('syms ");
            sb.append("x1_" + i);
            sb.append(" ;')\n");

            sb.append("x1(" + i + ",1" + ")" + " = x1_" + i + ";\n");
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                sb.append("eval('syms ");
                sb.append("r21_" + i + j );
                sb.append(" ;')\n");

                sb.append("R21(" + i + "," + j  + ")" + " = r21_" + i + j + ";\n");
            }
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                sb.append("eval('syms ");
                sb.append("r10_" + i + j );
                sb.append(" ;')\n");

                sb.append("R10(" + i + "," + j  + ")" + " = r10_" + i + j + ";\n");
            }
        }


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                for (int k = 1; k <= len; k++) {
                    sb.append("eval('syms ");
                    sb.append("t21_" + i + j + k);
                    sb.append(" ;')\n");

                    sb.append("T21(" + i + "," + j + "," + k + ")" + " = t21_" + i + j + k + ";\n");
                }
            }
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                for (int k = 1; k <= len; k++) {
                    sb.append("eval('syms ");
                    sb.append("t10_" + i + j + k);
                    sb.append(" ;')\n");

                    sb.append("T10(" + i + "," + j + "," + k + ")" + " = t10_" + i + j + k + ";\n");
                }
            }
        }


        final FileWriter fileWriter = new FileWriter(new File("matlabEval.txt"));
        fileWriter.write(sb.toString());
        fileWriter.close();

        System.err.println("finished");

//        new File("matlabEval.txt").delete();
    }

//    @org.junit.Test
    public void subExpressionTest() {
        final Expression expression = Expression.create("MyTools*MyTools+MyTools*b+b*b+MyTools");
        final Expression subExpression = expression.subExpression(Factor.create("MyTools"));
        System.err.println(subExpression);

        final Expression subExpression2 = expression.subExpression(Factor.create("b"));
        System.err.println(subExpression2);

        final Expression subExpression3 = expression.subExpression(Factor.create("b*b"));
        System.err.println(subExpression3);

        final Expression subExpression4 = expression.subExpression(Factor.create("MyTools*b"));
        System.err.println(subExpression4);

        final Expression subExpression5 = expression.subExpression(Factor.create("b*MyTools"));
        System.err.println(subExpression5);
    }

//    @org.junit.Test
    public void addTest() {
        Expression add = Expression.add(
                Expression.create("MyTools+b"), Expression.create("MyTools+c")
        );

        System.err.println(add);

        final Vector x1 = Vector.create("x", 6);
        final Vector x2 = Vector.create("x", 6);
        final Vector y = Vector.create("y", 6);

        System.err.println(Vector.add(x1, x1));
        System.err.println(Vector.add(x1, x1));
        System.err.println(Vector.add(x1, x2));
        System.err.println(Vector.add(x1, y));
        System.err.println(Vector.add(x1, y));
        System.err.println(Vector.add(Vector.add(x1, x1), y));
        System.err.println(Vector.add(Vector.add(x1, x1), Vector.add(x1, x1)));
    }

//    @org.junit.Test
    public void ExpressionTest02() {
        final Expression a = Expression.create("MyTools");
        final Expression ab = Expression.create("MyTools+b");
        final Expression ab2 = Expression.create("MyTools+b");

        System.err.println(Expression.multiply(a, ab));
        System.err.println(Expression.multiply(a, ab2));
        System.err.println(Expression.multiply(a, ab, ab));
        System.err.println(Expression.multiply(a, ab, ab2));
        System.err.println(Expression.multiply(a, ab2, ab2));
    }

//    @org.junit.Test
    public void Matrix3Test01() {
        final Matrix3 T = Matrix3.create("T", 2);
        T.printHalf(true);

        final Vector x = Vector.create("x", 2);
        final Vector y = Vector.create("y", 2);
        System.err.println(x);
        System.err.println(y);

        final Vector Txy = Matrix3.multiplyHalf(T, x, y);
        System.err.println(Txy);

        final Vector Txx = Matrix3.multiplyHalf(T, x, x);
        System.err.println(Txx);
    }


//    @org.junit.Test
    public void Matrix2Test01() {
        final Matrix2 matrix2 = Matrix2.create("A", 2);
        matrix2.print(5, true);

        final Vector x = Vector.create("x", 2);

        final Vector Ax = Matrix2.multiply(matrix2, x);
        System.err.println(Ax);
    }

//    @org.junit.Test
    public void VectorTest() {
        final Vector x0 = Vector.create("x0_", 6);

        System.err.println(x0);
    }

//    @org.junit.Test
    public void createTest() {
        final Factor a = Factor.create("MyTools");
        System.err.println(a);

        final Factor ab = Factor.create("MyTools*b");
        System.err.println(ab);

        final Expression e1 = Expression.create("MyTools+b");
        final Expression e2 = Expression.create("MyTools+b+b");
        System.err.println(e1);
        System.err.println(e2);

        final Expression e11 = Expression.multiply(e1, e1);
        final Expression e12 = Expression.multiply(e1, e2);
        System.err.println(e11);
        System.err.println(e12);


    }

//    @org.junit.Test
    public void ExpressionTest01() {
        // MyTools*b
        final Factor a = new Factor("MyTools");
        final Factor b = new Factor("b");

        final Factor ab = new Factor();
        ab.multiply(a);
        ab.multiply(b);
        System.err.println(ab);

        //MyTools*b*b
        final Factor abb = new Factor();
        abb.multiply(a);
        abb.multiply(a);
        abb.multiply(b);
        System.err.println(abb);

        final Expression expression = new Expression(ab);
        expression.add(abb);
        expression.add(abb);

        System.out.println("expression = " + expression);

    }

//    @org.junit.Test
    public void hasFactorTest() {
        final Factor a = new Factor("MyTools");
        final Factor b = new Factor("b");

        a.multiply(a);
        a.multiply(b);

        Assert.assertTrue(a.hasFactor(a));
        Assert.assertTrue(a.hasFactor(b));
        Assert.assertTrue(a.hasFactor(new Factor("MyTools")));

        b.multiply(new Factor("MyTools"));
        System.err.println(a);
        System.err.println(b);
        Assert.assertTrue(a.hasFactor(b));

        b.multiply(b);
        Assert.assertFalse(a.hasFactor(b));

        System.err.println(a);
        System.err.println(b);

    }

//    @org.junit.Test
    public void factorTest2() {
        Character ch = (char) (Math.random() * 10000);
        final Symbol a = new Symbol(ch.toString());
        final Symbol a1 = new Symbol(ch.toString());

        final Factor factor_a = new Factor(a);
        final Factor factor_a1 = new Factor(a1);

        final Factor f1 = new Factor();
        final Factor f2 = new Factor();

        Assert.assertFalse(f1 == f2);
        System.err.println(f1 == f2);

        f1.multiply(factor_a);
        f1.multiply(factor_a1);
        f1.multiply(factor_a);

        f2.multiply(factor_a);
        f2.multiply(factor_a);
        f2.multiply(factor_a1);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        Assert.assertTrue(f1.equals(f2));
        Assert.assertTrue(f2.equals(f1));

    }

//    @org.junit.Test
    public void factorTest() {
        final Factor a = new Factor("MyTools");
        final Factor a1 = new Factor("a1");

        a.multiply(a1);
        System.err.println(a);

        a.multiply(a);
        System.err.println(a);

        a.multiply(a);
        System.err.println(a);

        a.multiply(a1);
        a.multiply(a1);
        a.multiply(a1);
        System.err.println(a);

    }


//    @org.junit.Test
    public void SymbolTest() {
        Character ch = (char) (Math.random() * 10000);
        System.err.println("ch = " + ch + "/" + (int) ch);
        final Symbol a = new Symbol(ch.toString());
        final Symbol a1 = new Symbol(ch.toString());

        Assert.assertFalse(a == a1);

        Assert.assertTrue(a.equals(a1));
        Assert.assertTrue(a1.equals(a));


        Assert.assertTrue(a.toString().equals(ch.toString()));
    }
}
