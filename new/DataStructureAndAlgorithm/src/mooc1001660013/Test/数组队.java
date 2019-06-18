package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.QueueArrayMooc;
import mooc1001660013.ListSeriesMooc.QueueMooc;

public class 数组队 {
    public static void main(String[] args) {
        QueueMooc queueMooc = new QueueArrayMooc(10);
        queueMooc.enqueue(1);
        queueMooc.enqueue(2);
        queueMooc.enqueue(3);
        queueMooc.enqueue(4);
        queueMooc.print();

        System.out.println(queueMooc.dequeue());
        System.out.println(queueMooc.dequeue());
        System.out.println(queueMooc.dequeue());
        System.out.println(queueMooc.dequeue());
        //[1, 2, 3, 4]
        //1
        //2
        //3
        //4
    }
}
