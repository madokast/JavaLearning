package mooc1001660013.Test;

import mooc1001660013.ListSeriesMooc.QueueLinkedMooc;
import mooc1001660013.ListSeriesMooc.QueueMooc;

import java.util.stream.Stream;

public class 链式队 {
    public static void main(String[] args) {
        QueueMooc queueMooc = new QueueLinkedMooc();
        Stream.generate(Math::random).limit(20).forEach(e->queueMooc.enqueue((int)(e*10)));
        queueMooc.print();

        System.out.println(queueMooc.size());

        for (int i = 0; i < 21; i++) {
            System.out.println(queueMooc.dequeue());
        }
    }
}
