package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.StackArrayMooc;
import mooc1001660013.ListSeriesMooc.StackMooc;

public class 数组栈 {
    public static void main(String[] args) {
        StackMooc stackMooc = new StackArrayMooc(10);
        stackMooc.push(1);
        stackMooc.push(2);
        stackMooc.push(3);
        stackMooc.push(4);
        stackMooc.print();

        System.out.println(stackMooc.pop());
        System.out.println(stackMooc.pop());
        System.out.println(stackMooc.pop());
        System.out.println(stackMooc.pop());
    }
}
