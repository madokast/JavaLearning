package learn.算法第四版;

//即集合set，但是不支持去除元素

public interface Bag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
}
