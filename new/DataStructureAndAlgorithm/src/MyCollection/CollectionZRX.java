package MyCollection;

import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 *
 * @param <E> the type of elements in this collection
 *
 * @author madokast
 * @version 2019.4.25
 */

public interface CollectionZRX<E> extends IterableZRX<E> {
    // Query Operations

    /**
     * Returns the number of elements in this collection
     * @return Returns the number of elements in this collection
     */
    int size();

    /**
     * Returns {@code true} if this collection contains no elements.
     * @return {@code true} if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns {@code true} if this collection contains the specified element.
     * @param o element whose presence in this collection is to be tested
     * @return {@code true} if this collection contains the specified element.
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this collection.
     * @return an {@code Iterator} over the elements in this collection
     */
    IterableZRX<E> iterator();

    // Modification Operations

    /**
     * @param e element whose presence in this collection is to be ensured
     * @return {@code true} if this collection changed as a result of the call
     *
     */
    boolean add(E e);

    /**
     * 为什么add是泛型而remove不是呢？疑惑
     * @param o element to be removed from this collection
     * @return {@code true} if an element was removed as a result of this call
     */
    boolean remove(Object o);

    // Bulk Operations

    /**
     * java 1.8
     * Removes all of the elements of this collection that satisfy the given predicate.
     * @param filter a predicate which returns {@code true} for elements to be removed
     * @return {@code true} if any elements were removed
     * @throws NullPointerException if the specified filter is null
     */
    default boolean removeIf(Predicate<? super E> filter){
        Objects.requireNonNull(filter);
//        public static <T> T requireNonNull(T obj) {
//            if (obj == null)
//                throw new NullPointerException();
//            return obj;
//        }

        boolean removed = false;
        final IterableZRX<E> each = iterator();
        while(each.hasNext()){
            if(filter.test(each.next())){
                each.remove();
                removed=true;
            }
        }
        return removed;
    }

    /**
     * Removes all of the elements from this collection
     */
    void clear();

    default boolean retainAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("retainAll(CollectionZRX<?> c)");
    }

    default boolean containsAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("containsAll(CollectionZRX<?> c)");
    }

    default boolean addAll(CollectionZRX<? extends E> c){
        throw new UnsupportedOperationException("addAll(CollectionZRX<? extends E> c)");
    }

    default boolean removeAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("removeAll(CollectionZRX<?> c)");
    }

    default <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException("toArray(IntFunction<T[]> generator)");
        //return toArray(generator.apply(0));
    }

    default  <T> T[] toArray(T[] a){
        throw new UnsupportedOperationException("toArray(T[] a)");
    }

    default Object[] toArray(){
        throw new UnsupportedOperationException("toArray");
    }
}
