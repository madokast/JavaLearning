package MyCollection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 实现它的对象可以使用foreach语句
 * 这个接口好像自己写不出来
 * 因为forrach语句使用的是Iterator，而不是我写的IteratorZRX
 * @param <T> the type of elements returned by the iterator
 * @version 2019.4.26
 */

public interface IterableZRX<T> extends Iterable<T>{
    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    IteratorZRX<T> iteratorZRX();

    /**
     * 胡乱写一下，不一定能成
     * 说不定这样我的集合也可以用foreach了
     * @return 由IteratorZRX<T> iteratorZRX()得到的迭代器
     */
    @Override
    default Iterator<T> iterator(){
        return (Iterator<T>) iteratorZRX();
    }

    //以下不使用
    @Override
    default void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException("forEach(Consumer<? super T> action)");
    }

    @Override
    default Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("spliterator()");
    }
}
