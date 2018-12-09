package madokast;

import javax.lang.model.SourceVersion;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QueueMain {
    public static void priorotyQueue(){
        PriorityQueue pq = new PriorityQueue();
        pq.add(6);
        pq.add(-3);
        pq.add(20);
        pq.add(18);

        System.out.println("pq = " + pq);
        //pq = [-3, 6, 20, 18]

        System.out.println(pq.poll());//-3
        System.out.println(pq.poll());//6

        System.out.println("pq = " + pq);
        //pq = [18, 20]

    }

    public static void arrayDeque(){
        ArrayDeque stack = new ArrayDeque();
        stack.push("123");
        stack.push("edf");
        stack.push("czx");
        stack.push("546");

        System.out.println("stack = " + stack);
        //stack = [546, czx, edf, 123]

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //546
        //czx
        //edf
        //123
    }

    public static void main(String[] args) {
        //priorotyQueue();
        arrayDeque();

    }
}
