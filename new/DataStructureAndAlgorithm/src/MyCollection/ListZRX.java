package MyCollection;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

/**
 * list 有序表。每个元素有准确位置
 * 可允许相同元素，不同于set。（也可允许多个null元素）
 *
 * 新增方法：
 *  基于索引的元素访问，插入，删除
 *  特定元素位置的搜索——使用时应小心，因为内部实现可能是线性查找
 *
 * 特殊迭代器：ListIteratorZRX。
 *  1.允许元素插入/替换
 *  2.可以双向访问
 *  3.获得迭代器时，可以指定其处于特定的位置
 *
 * 警告：
 *  1.不要把list自身放到自己里面，这会导致equals/hashCode方法出现问题
 *  2.有的list不允许插入null或某些元素。也不允许询问这些元素。（会抛出异常）
 *
 * 不可变list：
 *  List.copyOf()静态工厂手段可以方便的获得不可变list
 *
 * 新增的需要实现的方法：
 *      E get(int index);
 *      E set(int index,E element);
 *      void add(int index, E element);
 *      E remove(int index);
 *      int indexOf(Object o);
 *      ListIteratorZRX<E> listIteratorZRX();
 *
 * 附录：CollectionZRX接口中
 *      需要实现的方法：
 *            int size();
 *            boolean isEmpty();
 *            boolean contains(Object o);
 *            IteratorZRX<E> iterator();
 *            boolean add(E e);
 *            boolean remove(Object o);
 *            void clear();
 *      需要重写的方法：
 *            boolean equals(Object o);
 *            int hashCode();
 *
 *
 * @param <E> the type of elements in this collection.
 * @version 2019.5.15
 */

public interface ListZRX<E> extends CollectionZRX<E> {
    //Query 操作

    /**
     *
     * @return list中元素数
     */
    @Override
    int size();

    /**
     *
     * @return list是否空
     */
    @Override
    boolean isEmpty();

    /**
     *
     * @param o element whose presence in this list is to be tested
     * @return 是否包含该元素
     */
    @Override
    boolean contains(Object o);

    /**
     *
     * @return 返回迭代器
     */
    @Override
    IteratorZRX<E> iteratorZRX();

    //modification 操作

    /**
     *
     * @param e element whose presence in this collection is to be ensured
     * @return if this collection changed as a result of the call
     */
    @Override
    boolean add(E e);

    /**
     *
     * @param o element to be removed from this collection
     * @return if this list contained the specified element
     */
    @Override
    boolean remove(Object o);

    /**
     * Removes all of the elements from this list
     */
    @Override
    void clear();

    /**
     * 会比较两个list的每个索引的元素是否相等
     * @param o object to be compared for equality with this collection
     * @return 是否相等
     */
    @Override
    boolean equals(Object o);

    /**
     * 计算方法如下
     * inr hashCode = 1;
     * for(E e : list)
     * hashCode = 31*hashCode + (e==? 0 : e.hashCode());
     * @return the hash code value for this list
     */
    @Override
    int hashCode();

    //positional 操作

    /**
     *
     * @param index 索引
     * @return 该索引元素
     * @throws IndexOutOfBoundsException 出界异常
     */
    E get(int index);

    /**
     * 替换对应索引处的元素
     * @param index 索引
     * @param element 要替换的元素
     * @return 原元素/被替换的元素
     */
    E set(int index,E element);

    /**
     * 在列表的指定位置插入指定元素
     * 会移动其右边的元素
     * @param index 位置索引
     * @param element 要插入的元素
     */
    void add(int index, E element);

    /**
     * 移走指定位置元素，会把右边的元素都左移
     * @param index 索引位置
     * @return 被移走的元素
     */
    E remove(int index);

    //查找操作

    /**
     * 找到第一次遇到的该元素的索引
     * @param o 倍查找的元素
     * @return 位置。-1表示没有找到
     */
    int indexOf(Object o);

    //迭代器

    /**
     * 特殊迭代器
     * @return a list iterator over the elements in this list
     */
    ListIteratorZRX<E> listIteratorZRX();

    //以下方法不用
    //以下方法不用
    //以下方法不用
    //以下方法不用
    //以下方法不用







    @Deprecated @Override
    default Object[] toArray(){
        throw new UnsupportedOperationException("toArray");
    }

    @Deprecated @Override
    default  <T> T[] toArray(T[] a){
        throw new UnsupportedOperationException("<T> T[] toArry(T[] a)");
    }

    @Deprecated @Override
    default boolean containsAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("containsAll(CollectionZRX<?> c)");
    }

    @Deprecated @Override
    default boolean addAll(CollectionZRX<? extends E> c){
        throw new UnsupportedOperationException("addAll(CollectionZRX<? extends E> c)");
    }

    @Deprecated
    default boolean addAll(int index, CollectionZRX<? extends E> c){
        throw new UnsupportedOperationException("addAll(int index, Collection<? extends E> c)");
    }

    @Deprecated @Override
    default boolean removeAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("boolean removeAll(Collection<?> c)");
    }

    @Deprecated @Override
    default boolean retainAll(CollectionZRX<?> c){
        throw  new UnsupportedOperationException("boolean retainAll(Collection<?> c)");
    }

    @Deprecated
    default void replaceAll(UnaryOperator<E> operator){
        throw new UnsupportedOperationException("default void replaceAll(UnaryOperator<E> operator)");
    }

    @Deprecated
    default void sort(Comparator<? super E> c){
        throw new UnsupportedOperationException("default void sort(Comparator<? super E> c)");
    }

    @Deprecated
    default int lastIndexOf(Object o){
        throw new UnsupportedOperationException("int lastIndexOf(Object o);");
    }

    @Deprecated
    default ListIteratorZRX<E> listIteratorZRX(int index){
        throw new UnsupportedOperationException("ListIterator<E> listIterator(int index);");
    }

    @Deprecated
    default ListZRX<E> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException("List<E> subList(int fromIndex, int toIndex);");
    }

    @Deprecated @Override
     default Spliterator<E> spliterator(){
        throw new UnsupportedOperationException("default Spliterator<E> spliterator()");
    }

    /**
     * Returns an unmodifiable list containing zero elements.
     * @since 9
     */
    @Deprecated
    static <E> ListZRX<E> of(){
        throw new UnsupportedOperationException("static <E> List<E> of()");
    }

    /**
     * Returns an unmodifiable list containing one element.
     * @since 9
     */
    @Deprecated
    static <E> ListZRX<E> of(E e1){
        throw new UnsupportedOperationException("static <E> List<E> of(E e1)");
    }

    /**
     * Returns an unmodifiable list containing two elements.9
     */
    @Deprecated
    static <E> ListZRX<E> of(E e1, E e2) {
        throw new UnsupportedOperationException("static <E> List<E> of(E e1, E e2)");
    }

    /**
     * Returns an unmodifiable list containing three elements.
     * @since 9
     */
    static <E> ListZRX<E> of(E e1, E e2, E e3) {
        throw new UnsupportedOperationException("static <E> List<E> of(E e1, E e2, E e3)");
    }

    //我要疯了 4 5 6 7 8 9 10

    @Deprecated
    static <E> ListZRX<E> of(E... elements){
        throw new UnsupportedOperationException("static <E> List<E> of(E... elements)");
    }

    /**
     * 返回给定集合中元素组成的不可变类
     * @since 10
     */
    @Deprecated
    static <E> ListZRX<E> copyOf(CollectionZRX<? extends E> coll){
        throw new UnsupportedOperationException("static <E> List<E> copyOf(Collection<? extends E> coll)");
    }
}


