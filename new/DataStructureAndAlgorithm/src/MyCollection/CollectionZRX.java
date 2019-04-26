package MyCollection;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @param <E> the type of elements in this collection.
 * 需要实现的方法：
 *           int size();
 *           boolean isEmpty();
 *           boolean contains(Object o);
 *           IteratorZRX<E> iterator();
 *           boolean add(E e);
 *           boolean remove(Object o);
 *           void clear();
 * 需要重写的方法：
 *           boolean equals(Object o);
 *           int hashCode();
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
     * 这只是一个强调应实现该接口
     * Returns an iterator over the elements in this collection.
     * @return an {@code Iterator} over the elements in this collection
     */
    @Override
    IteratorZRX<E> iteratorZRX();

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

    /**
     * Removes all of the elements from this collection
     */
    void clear();

    /**
     * 应当重写Object.equals
     * 实际上实现者不重写你也管不着
     * @param o object to be compared for equality with this collection
     * @return {@code true} if the specified object is equal to this
     */
    @Override
    boolean equals(Object o);

    /**
     * 因为重写了Object.equals，所以应该重写hashCode
     * 相同的对象必须要有相同的hashCode值
     * @return
     */
    @Override
    int hashCode();


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
        final IteratorZRX<E> each = iteratorZRX();
        while(each.hasNext()){
            if(filter.test(each.next())){
                each.remove();
                removed=true;
            }
        }
        return removed;
    }

    //下面的操作不实现了

    /**
     * 可分割迭代器(splitable iterator)
     * 用来多线程并行迭代的迭代器，
     * 这个迭代器的主要作用就是把集合分成了好几段，
     * 每个线程执行一段，因此是线程安全的
     *
     * 重写自IterableZRX<T>
     */
    @Override
    default Spliterator<E> spliterator() {
        throw new UnsupportedOperationException("spliterator()");
    }

    // TODO: 2019/4/26 学习流处理
    default Stream<E> stream() {
        throw new UnsupportedOperationException("stream()");
    }

    default Stream<E> parallelStream() {
        throw new UnsupportedOperationException("parallelStream()");
    }

    @Deprecated
    default boolean retainAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("retainAll(CollectionZRX<?> c)");
    }

    @Deprecated
    default boolean containsAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("containsAll(CollectionZRX<?> c)");
    }

    @Deprecated
    default boolean addAll(CollectionZRX<? extends E> c){
        throw new UnsupportedOperationException("addAll(CollectionZRX<? extends E> c)");
    }

    @Deprecated
    default boolean removeAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("removeAll(CollectionZRX<?> c)");
    }

    @Deprecated
    default <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException("toArray(IntFunction<T[]> generator)");
        //return toArray(generator.apply(0));
    }

    @Deprecated
    default  <T> T[] toArray(T[] a){
        throw new UnsupportedOperationException("toArray(T[] a)");
    }

    @Deprecated
    default Object[] toArray(){
        throw new UnsupportedOperationException("toArray");
    }
}
