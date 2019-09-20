package learn.算法第四版;

public interface Stack<Item> extends Iterable<Item>{
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
