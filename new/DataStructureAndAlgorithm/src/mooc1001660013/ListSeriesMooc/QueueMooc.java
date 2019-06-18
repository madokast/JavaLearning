package mooc1001660013.ListSeriesMooc;

public interface QueueMooc extends ListMooc {
    default boolean enqueue(int e){
        return insert(e);
    }

    default int dequeue(){
        int t = get(0);
        delete(0);
        return t;
    }
}
