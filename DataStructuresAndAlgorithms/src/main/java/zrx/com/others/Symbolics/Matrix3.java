package zrx.com.others.Symbolics;

import java.util.Arrays;

/**
 * 三维方阵
 */

public class Matrix3 {
    Expression[][][] m3;
    String name;
    int length;

    public static Vector multiplyHalf(Matrix3 matrix3,Vector vector1,Vector vector2,String name){
        final int length = matrix3.length;
        if(length !=vector1.length||length !=vector2.length){
            throw new RuntimeException("矩阵*矢量 发生维度错误");
        }

        final Vector ans = new Vector(length);
        ans.name = name;

        for (int i = 1; i <= length; i++) {
            ans.v[i] = new Expression();

            for (int j = 1; j <= length; j++) {
                for (int k = 1; k <= length; k++) {
                    if(k>=j){
                        ans.v[i].add(Expression.multiply(matrix3.m3[i][j][k],
                                        vector1.v[j],
                                        vector2.v[k])
                        );
                    }
                }
            }
        }

        return ans;
    }

    public static Vector multiplyHalf(Matrix3 matrix3,Vector vector1,Vector vector2){
        return multiplyHalf(matrix3,vector1,vector2,
                matrix3.name+"*"+vector1.name+"*"+vector2.name
                );
    }

    @Override
    public String toString() {
        return "请使用printHalf";
    }

    public void printHalf(boolean isErr){
        final StringBuilder sb = new StringBuilder();
        sb.append("打印三维矩阵：");
        sb.append(name);
        sb.append("\n");

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                for (int k = 1; k <= length; k++) {
                    if(k>=j){
                        sb.append(name);
                        sb.append(i);
                        sb.append(j);
                        sb.append(k);
                        sb.append(" = ");

                        sb.append(m3[i][j][k]);
                        sb.append("\n");
                    }
                }
            }
        }

        if(isErr){
            System.err.println(sb.toString());
        }else {
            System.out.println(sb.toString());
        }

    }

    Matrix3(int length, String name) {
        this.name = name;
        this.length = length;

        m3 = new Expression[length + 1][][];
        for (int i = 1; i <= length; i++) {
            m3[i] = new Expression[length + 1][];
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                m3[i][j] = new Expression[length + 1];
            }
        }
    }

    public static Matrix3 create(String name,int length){
        final Matrix3 matrix3 = new Matrix3(length, name);

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                for (int k = 1; k <= length; k++) {
                    matrix3.m3[i][j][k] = Expression.create(name+i+j+k);
                }
            }
        }

        return matrix3;
    }
}
