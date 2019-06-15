package mooc1001660013;

public interface ListMooc {
    int size();

    int get(int i);

    boolean insert(int e, int i);

    default boolean insert(int e) {
        return insert(e, size());
    }

    boolean delete(int i);

    default boolean delete() {
        return delete(size() - 1);
    }

    default int search(int e) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == e)
                return i;
        }
        return -1;
    }

    default boolean isSorted() {
        for (int i = 0; i < size() - 1; i++) {
            if (get(i) > get(i + 1))
                return false;
        }
        return true;
    }

    String toString();

    default void print() {
        System.out.println(toString());
    }
}
