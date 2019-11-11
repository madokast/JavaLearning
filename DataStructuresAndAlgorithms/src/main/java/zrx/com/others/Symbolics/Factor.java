package zrx.com.others.Symbolics;

import org.hamcrest.core.Is;

import java.io.PrintWriter;
import java.util.*;

/**
 * 因子，由符号相乘获得
 * 单个符号也是因子
 * 用一个map存储因子中的所有符号
 * k = 符号
 * v = 阶数
 *
 * 如 因子 = (A12,1) (MyTools,2)
 * 即表示"A12 * MyTools * MyTools"
 *
 * 没有系数
 */

public class Factor {
    private Map<Symbol,Integer> f;

    public boolean containNoMoreNoLess(final Factor in,final Factor out){

        final Set<Map.Entry<Symbol, Integer>> setOut = out.f.entrySet();

        for (Map.Entry<Symbol, Integer> entry : setOut) {
            final Symbol key = entry.getKey();
            if(f.containsKey(key)){
                return false;
            }
        }


        return this.containNoMoreNoLess(in);
    }

    public boolean containNoMoreNoLess(final Factor factor){
        final Set<Map.Entry<Symbol, Integer>> entries = factor.f.entrySet();
        for (Map.Entry<Symbol, Integer> entry : entries) {
            final Symbol key = entry.getKey();
            final Integer value = entry.getValue();


            if(f.containsKey(key)){
                if(!f.get(key).equals(value)){
                    return false;
                }
            }else {
                return false;
            }
        }

        return true;
    }

    public boolean hasFactor(final Factor factor){
        final Set<Map.Entry<Symbol, Integer>> set = factor.f.entrySet();
        for (Map.Entry<Symbol, Integer> entry : set) {
            final Symbol key = entry.getKey();
            final Integer value = entry.getValue();

            if(f.containsKey(key)){
                if(f.get(key).compareTo(value)<0){
                    return false;
                }
            }else {
                return false;
            }

        }
        return true;
    }

    //相等判断
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factor factor = (Factor) o;

        return f != null ? f.equals(factor.f) : factor.f == null;
    }

    @Override
    public int hashCode() {
        return f != null ? f.hashCode() : 0;
    }

    /**
     * 打印因数
     * @return like MyTools*b*b
     */
    @Override
    public String toString() {
        final Set<Map.Entry<Symbol, Integer>> entries = f.entrySet();
        final StringBuilder sb = new StringBuilder();

        if(entries.size()==0)
            return "1";

        for (Map.Entry<Symbol, Integer> entry : entries) {
            appendSymbol(sb,entry.getKey(),entry.getValue());
        }

        return sb.toString();
    }

    // toString help
    private void appendSymbol(StringBuilder sb,Symbol symbol,Integer degree){
        if(sb.length()!=0){
            sb.append("*");
        }
        appendSymbol0(sb,symbol,degree);
    }

    // toString help
    private void appendSymbol0(StringBuilder sb,Symbol symbol,Integer degree){
        if(degree==0)
            return;

        for (int i = 0; i < degree; i++) {
            sb.append(symbol);
            sb.append("*");
        }

        //删除最后的*
        sb.deleteCharAt(sb.length()-1);
    }

    /**
     * 因数相乘
     * @param factor 因数
     */
    public void multiply(Factor factor){
        for (Map.Entry<Symbol, Integer> entry : factor.f.entrySet()) {
            final Symbol key = entry.getKey();
            final Integer value = entry.getValue();

            if(f.containsKey(key)){
                f.put(key,f.get(key)+value);
            }else {
                f.put(key,value);
            }
        }
    }

    public static Factor multiply(final Factor f1,final Factor f2){
        final Factor factor = new Factor();
        factor.multiply(f1);
        factor.multiply(f2);

        return factor;
    }


    /**
     * 构造器
     */
    public Factor(){
        //空代表单位1
        f = new HashMap<Symbol,Integer>();
    }
    public Factor(Symbol symbol){
        this();
        f.put(symbol,1);
    }
    public Factor(String sym){
        this(new Symbol(sym));
    }

    public static Factor create(String factor){
        final Factor f = new Factor();
        final String[] strings = factor.split("\\*");

        for (String string : strings) {
            f.multiply(new Factor(string));
        }

        return f;
    }
}
