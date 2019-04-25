package MyCollection;

import java.util.function.Consumer;

/**
 * Iterator of collection
 * a member of collection framework.
 *
 * @param <E> the type of elements returned by the iterator
 *
 * @author madokast
 * @version 2019.4.25
 */

//学习文档写法

public interface IterableZRX<E> {
    /**
     *  Return {@code true} if thr iteration has more elements.
     *  call and check it before using next() mathod everytime.
     *
     * @return {@code true} if thr iteration has more elements.
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    E next();

    /**
     * 禁止实现它
     *
     * @deprecated
     */
    default void remove(){
        throw new UnsupportedOperationException("remove");
    }

    /**
     * 暂未实现
     *
     * @param action The action to be performed for each element
     */
    default void forEachRemaining(Consumer<? super E> action){
        // TODO: 2019/4/25 学习流处理，forEachRemaining Consumer
        throw new UnsupportedOperationException("forEachRemaining");
    }

}
