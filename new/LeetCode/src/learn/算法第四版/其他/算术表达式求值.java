package learn.算法第四版.其他;

import java.util.Stack;

public class 算术表达式求值 {
    public static void main(String[] args) {
        final String evl = "( ( 1 + 1 ) + ( 4 * 5 ) )";

        //双栈
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        final String[] evls = evl.split(" ");

        for (String o : evls) {
            System.out.print("look:"+o+"...:");
            switch (o){
                case "(":
                    System.out.println("(");
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    System.out.println("op:"+o);
                    operators.push(o);
                    break;
                case ")":
                    //计算
                    System.out.println(")");
                    final String operator = operators.pop();
                    final Integer o2 = operands.pop();
                    final Integer o1 = operands.pop();
                    switch (operator){
                        case "+":
                            operands.push(o1+o2);
                            break;
                        case "-":
                            operands.push(o1-o2);
                            break;
                        case "*":
                            operands.push(o1*o2);
                            break;
                        case "/":
                            operands.push(o1/o2);
                            break;
                    }
                    break;
                default:
                    System.out.println("num:"+o);
                    operands.push(Integer.valueOf(o));
            }

        }

        System.out.println("size:"+operands.size());
        System.out.println("evl="+operands.pop());


    }
}
