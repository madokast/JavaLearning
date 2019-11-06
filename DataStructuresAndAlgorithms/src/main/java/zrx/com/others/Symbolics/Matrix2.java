package zrx.com.others.Symbolics;

import java.util.Arrays;

/**
 * 二维方阵
 *
 * 从(1,1)开始!!!!
 * 从(1,1)开始!!!!
 * 从(1,1)开始!!!!
 * 从(1,1)开始!!!!
 */

public class Matrix2 {
     Expression[][] m2;
     String name;
     int length;

    public static Vector multiply(Matrix2 matrix2,Vector vector,String name){
        final int length = matrix2.length;
        if(length !=vector.length){
            throw new RuntimeException("矩阵*矢量 发生维度错误");
        }

        final Vector ans = new Vector(length);
        ans.name = name;

        for (int i = 1; i <= length; i++) {
            ans.v[i] = new Expression();

            for (int j = 1; j <= length; j++) {
                ans.v[i].add(
                        Expression.multiply(matrix2.m2[i][j],vector.v[j])
                );
            }
        }

        return ans;

    }

    public static Vector multiply(Matrix2 matrix2,Vector vector){
        return multiply(matrix2,vector,matrix2.name+"*"+vector.name);
    }


    private Matrix2(int length){
        m2 = new Expression[length+1][];
        for (int i = 1; i <= length ; i++) {
            m2[i] = new Expression[length+1];
        }

        this.length = length;
    }

    public static Matrix2 create(String sym,int length){
        final Matrix2 matrix2 = new Matrix2(length);
        matrix2.name = sym;

        for (int i = 1; i <= length ; i++) {
            for (int j = 1; j <= length; j++) {
                matrix2.m2[i][j] = Expression.create(sym+i+j);
            }
        }

        return matrix2;
    }

    @Override
    public String toString() {
        return "请使用print";
    }

    public void print(int width,boolean isErr){
        final String form = "%"+width+"s";

        final StringBuilder sb = new StringBuilder();
        sb.append("打印二维矩阵：");
        sb.append(name);
        sb.append("\n");

        for (int i = 1; i <= length ; i++) {
            for (int j = 1; j <= length; j++) {
                sb.append(String.format(form,m2[i][j]));
            }
            sb.append("\n");
        }

        if(isErr){
            System.err.println(sb.toString());
        }else {
            System.out.println(sb.toString());
        }

    }
}
