package MyCollection;

import java.util.Objects;

/**
 * AbstractCollectionZRX 用于提供 CollectionZRX 的骨架实现，以减小实现 CollectionZRX 的工作量
 *
 * 如果要实现不可变集合，只需要实现 size 和 iterator ，后者需要实现 Iterator 的 hasNext 和 next
 *
 * 如果要实现可变集合，还需要实现 add 方法(本类中它会抛出操作不支持异常)，还要实现 Iterator 的 remove
 *
 * 构造器：需要提供无参构造器，以及含 CollectionZRX 参数的构造器。（每个集合类都应遵守）
 *
 * 本抽象类中，非抽象方法如果有更好/更高效的实现，应当重写
 *
 * @param <E> 集合元素
 * @version 2019.5.16
 */

public abstract class AbstractCollectionZRX<E> implements CollectionZRX<E> {

    protected AbstractCollectionZRX(){}

    @Override
    public abstract IteratorZRX<E> iteratorZRX();

    @Override
    public abstract int size();

    @Override
    public boolean isEmpty(){return size()==0;}

    @Override
    public boolean contains(Object o){//哈哈哈，没有我写的好
        IteratorZRX<E> it = iteratorZRX();
        while(it.hasNext())
            if(Objects.equals(o,it.next()))
                return true;

        return false;
    }

    /**
     * 不支持add操作，比如不变集合
     * @param e element whose presence in this collection is to be ensured
     * @return null
     */
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * 通过迭代器的remove来移除元素
     * @param o element to be removed from this collection
     * @return 删除成功返回true，否则false
     */
    @Override
    public boolean remove(Object o){
        IteratorZRX<E> it = iteratorZRX();
        while(it.hasNext()){
            if(Objects.equals(o,it.next())){
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * 没有想到是这样实现的的
     */
    @Override
    public void clear(){
        IteratorZRX<E> it = iteratorZRX();
        while(it.hasNext()){
            it.next();
            it.remove();
        }
    }

    @Override
    public String toString(){
        IteratorZRX<E> it = iteratorZRX();
        if(!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(;;){
            E e = it.next();
            sb.append(e == this? "(this collection)" : e);
            if(!it.hasNext())
                return sb.append(']').toString();

            sb.append(',').append(' ');//这个操作比 append(", ") 要好？
        }
    }


    /*
    * 为什么不重写 equals 和 hashCose 方法？
    * 既然已经默认迭代器实现了
    * 奇怪呢
    * */









    //以下方法不用（主要是 块操作 和 变数组 ）
    //以下方法不用
    //以下方法不用
    //以下方法不用


    @Override @Deprecated
    public Object[] toArray(){
        throw new UnsupportedOperationException("public Object[] toArray()");
        //看了源代码，似乎这个方法可以适应于迭代器凸出的元素大于小于size()
        //最开始arr.length = size()，但是迭代中可能有并行造作导致迭代器吐出的元素数目不等于size()
        //使用Arrays.copyOf(arr,index)处理过少元素
        //使用finishToArray(arr,iterator)处理过多元素
    }

    @Override @Deprecated
    public <T> T[] toArray(T[] a){
        throw new UnsupportedOperationException("toArray(T[] a)");
        //看源码时发现了数组的构造器
        //java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), size);
    }

    /**
     * 因为有的 VM 需要预留头信息，所以大小为 MAX-8
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 用于 toArray 方法中，迭代器莫名其妙的突出了多于 size 的元素
     */
    @Deprecated
    private static <T> T[] finishToArray(T[] r, IteratorZRX<?> it){
        throw new UnsupportedOperationException("private static <T> T[] finishToArray(T[] r, Iterator<?> it)");
    }

    @Deprecated
    private static int hugeCapacity(int minCapacity){
        throw new UnsupportedOperationException("private static int hugeCapacity(int minCapacity)");
    }

    @Override @Deprecated
    public boolean containsAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("public boolean containsAll(Collection<?> c)");
    }

    @Override @Deprecated
    public boolean addAll(CollectionZRX<? extends E> c){
        throw new UnsupportedOperationException("public boolean addAll(Collection<? extends E> c)");
    }

    @Override @Deprecated
    public boolean removeAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("public boolean removeAll(Collection<?> c)");
    }

    @Override @Deprecated
    public boolean retainAll(CollectionZRX<?> c){
        throw new UnsupportedOperationException("public boolean retainAll(Collection<?> c)");
        //仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。
    }

}
