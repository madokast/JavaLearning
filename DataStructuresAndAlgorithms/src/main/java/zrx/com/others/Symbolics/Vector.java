package zrx.com.others.Symbolics;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 一维矢量
 * 符号型
 *
 * 从一开始!!!!
 * 从一开始!!!!
 * 从一开始!!!!
 * 从一开始!!!!
 */

public class Vector {
    Expression[] v;
    String name;
    int length;

    public static Vector add(Vector v1,Vector v2,String name){
        if(v2.length!=v1.length){
            throw new RuntimeException("不同维度矢量不能想加");
        }

        final Vector ans = new Vector(v1.length);
        ans.name = name;

        for (int i = 1; i <= ans.length; i++) {

            ans.v[i] = Expression.add(v1.v[i],v2.v[i]);
        }

        return ans;
    }

    public static Vector add(Vector v1,Vector v2){
        return add(v1,v2,v1.name+"+"+v2.name);
    }

    public void add(Vector v2){
        if(v2.length!=length){
            throw new RuntimeException("不同维度矢量不能想加");
        }

        for (int i = 1; i <= length; i++) {
            v[i].add(v2.v[i]);
        }
    }

    public Expression get(int i){
        return v[i];
    }

    public void set(Expression e,int i){
        v[i]=e;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("打印矢量：");
        sb.append(name);
        sb.append("\n");

        for (int i = 1; i <= length; i++) {
            sb.append(v[i].toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    Vector(int length){
        v = new Expression[length+1];
        this.length = length;
    }

    public static Vector create(String sym, int length){
        final Vector vector = new Vector(length);

        vector.name=sym;

        for (int i = 1 ; i <= length ; i++) {
            vector.set(
                    Expression.create(sym+i),i
            );
        }

        return vector;
    }
}
