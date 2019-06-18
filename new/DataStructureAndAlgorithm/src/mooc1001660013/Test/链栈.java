package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.StackLinkedMooc;
import mooc1001660013.ListSeriesMooc.StackMooc;

import java.util.stream.Stream;

public class 链栈 {
    public static void main(String[] args) {
        StackMooc stackMooc = new StackLinkedMooc();
        stackMooc.print();
        Stream.generate(Math::random).limit(20).forEach(e->stackMooc.push((int)(e*10)));
        stackMooc.print();
        for (int i = 0; i < 21; i++) {
            System.out.println(stackMooc.pop());
        }
    }
}
