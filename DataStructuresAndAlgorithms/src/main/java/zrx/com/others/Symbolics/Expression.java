package zrx.com.others.Symbolics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 表达式
 * 由factor相加组成
 *
 * 用Map装其中的factor和系数
 */

public class Expression {
    private Map<Factor,Integer> e;

    public int size(){
        return e.size();
    }


    /**
     * 鬼斧神工开始了!!!
     * 表达式 MyTools*MyTools + MyTools*b + b*b +MyTools
     * 输入factor MyTools
     * 则返回 MyTools*b +MyTools
     *
     * 即返回带有factor 相同次项的子表达式
     *
     * @param factor
     * @return
     */
    public Expression subExpression(Factor factor){
        final Expression sub = new Expression();

        final Set<Map.Entry<Factor, Integer>> set = e.entrySet();
        for (Map.Entry<Factor, Integer> entry : set) {
            final Factor key = entry.getKey();
            final Integer value = entry.getValue();

            if(key.containNoMoreNoLess(factor)){
                sub.add(key,value);
            }
        }

        return sub;
    }

    public Expression subExpressionOut(Factor out){
        Expression sub = new Expression();

        final Set<Map.Entry<Factor, Integer>> s = e.entrySet();
        for (Map.Entry<Factor, Integer> entry : s) {
            final Factor key = entry.getKey();
            final Integer value = entry.getValue();
            if(!key.hasFactor(out)){
                sub.add(key,value);
            }
        }

        return sub;
    }




    public boolean isEmpty(){
        return e.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Set<Map.Entry<Factor, Integer>> entries = e.entrySet();
        for (Map.Entry<Factor, Integer> entry : entries) {
            final Factor key = entry.getKey();
            final Integer value = entry.getValue();

            if(value!=1){
                sb.append(value);
                sb.append("*");
            }

            sb.append(key);
            sb.append("+");
        }

        //删除最后的+
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     *
     * 表达式乘法
     * @param e1 因数1
     * @param e2 因数2
     * @return e1*e2
     */
    public static Expression multiply(Expression e1,Expression e2){


        final Expression expression = new Expression();

        final Set<Map.Entry<Factor, Integer>> set1 = e1.e.entrySet();
        final Set<Map.Entry<Factor, Integer>> set2 = e2.e.entrySet();

        for (Map.Entry<Factor, Integer> entry11 : set1) {
            final Factor key11 = entry11.getKey();
            final Integer value11 = entry11.getValue();
            for (Map.Entry<Factor, Integer> entry22 : set2) {
                final Factor key22 = entry22.getKey();
                final Integer value22 = entry22.getValue();

                expression.add(
                        Factor.multiply(key11,key22),value11*value22
                );

            }
        }

        return expression;
    }

    public static Expression multiply(Expression...expressions){

        if(expressions.length==1){
            return expressions[0];
        }

        Expression ans = Expression.multiply(expressions[0], expressions[1]);

        for (int i = 2; i < expressions.length; i++) {
            ans = Expression.multiply(ans,expressions[i]);
        }

        return ans;
    }

    /**
     * 表达式加法
     * @param expression 加数
     */
    public void add(Expression expression){
        final Set<Map.Entry<Factor, Integer>> entries = expression.e.entrySet();
        for (Map.Entry<Factor, Integer> entry : entries) {
            final Factor key = entry.getKey();
            final Integer value = entry.getValue();

            if(e.containsKey(key)){
                //为零
                if((e.get(key)+value)==0){
                    e.remove(key);
                }else {
                    e.put(key,e.get(key)+value);
                }
            }else {
                e.put(key,value);
            }
        }
    }

    public static Expression add(Expression e1,Expression e2){
        final Expression ans = new Expression();
        ans.add(e1);
        ans.add(e2);

        return ans;
    }

    public void add(Factor factor){
        this.add(new Expression(factor));
    }

    public void add(Factor factor, Integer degree){
        this.add(new Expression(factor,degree));
    }

    //构造器
    public Expression(){
        e = new HashMap<Factor, Integer>();
    }
    public Expression(Factor factor,Integer degree){
        this();
        e.put(factor,degree);
    }
    public Expression(Factor factor){
        this(factor,1);
    }
    public Expression(Symbol symbol){
        this(new Factor(symbol));
    }
    public Expression(String sym){
        this(new Factor(sym));
    }

    public static Expression create(String exp){
        final Expression expression = new Expression();
        final String[] split = exp.split("\\+");

        for (String f : split) {
            expression.add(Factor.create(f));
        }

        return expression;
    }


}
