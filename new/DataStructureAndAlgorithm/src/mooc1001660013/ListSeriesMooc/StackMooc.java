package mooc1001660013.ListSeriesMooc;

public interface StackMooc extends ListMooc {
    default boolean push(int e){
        return insert(e,size());
    }

    default int pop(){
        int t = get(size()-1);
        delete(size()-1);
        return t;
    }
}
