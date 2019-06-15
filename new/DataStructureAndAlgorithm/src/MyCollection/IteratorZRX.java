package MyCollection;

import java.util.function.Consumer;

/**
 * Iterator of collection
 * a member of collection framework.
 *
 * 2019.4.25 建立
 * 2019.4.26 改名
 * @param <E> the type of elements returned by the iterator
 *
 * @author madokast
 * @version 2019.4.25
 */

//学习文档写法

public interface IteratorZRX<E> {
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
     * 也许需要实现它
     * default方法，在接口中可以有方法体，即不必实现它，但是可以重写（废话）
     * @deprecated
     */
    @Deprecated
    default void remove(){
        throw new UnsupportedOperationException("remove");
    }

    /**
     * 暂未实现
     * Java9中出现的新方法
     * @param action The action to be performed for each element
     */
    default void forEachRemaining(Consumer<? super E> action){
        // TODO: 2019/4/25 学习流处理，forEachRemaining Consumer
        throw new UnsupportedOperationException("forEachRemaining");
    }

}
