package MyCollection;

/**
 * 有序表 list 的骨架实现。主要用于实现 数组list 和 ×链表list
 *      “此类提供 List 接口的骨干实现，以最大限度地减少实现“随机访问”数据存储（如数组）支持的该接口所需的工作。
 *      “对于连续的访问数据（如链表），应优先使用 AbstractSequentialList，而不是此类。”
 *
 * 不可变list：只需实现 get() 和 size() 方法
 *
 * 可变list：需要重写 set() 方法
 *
 * 尺寸size可变list：重写 add() remove() 方法
 *
 * 构造器：空参数构造器 和 集合构造器 是必须的
 *
 * !!!
 * 迭代器：不需要提供迭代器的实现，这点不同于实现其他的抽象集合。
 * “迭代器和列表迭代器由此类在以下“随机访问”方法上实现：
 * “get(int)、set(int, E)、add(int, E) 和 remove(int)。”
 *              ——吐槽：这行吗？链表不维护一个当前元素指针，怎么好迭代？
 *              ——回复：这个抽象类只用来实现 数组型list ，若要实现 linkedList ，请继承 AbstractSequentialList
 *
 * 备忘：
 *  AbstractCollectionZRX重要抽象方法：
 *      public abstract IteratorZRX<E> iteratorZRX();
 *      public abstract int size();
 *  AbstractCollectionZRX已实现的方法：
 *      public boolean isEmpty(){return size()==0;}
 *      public boolean contains(Object o){利用迭代器顺序查找}
 *      public boolean add(E e){不支持}
 *      public boolean remove(Object o){迭代器查找后remove}
 *      public void clear(){迭代器查找后remove}
 *      public String toString(){完美实现}
 *      另外的块操作、变数组操作 Deprecated
 *
 *  ListZRX中重要抽象方法：（不包含在AbstractCollectionZRX已实现的）
 *    两个迭代器：
 *      IteratorZRX<E> iteratorZRX();
 *      ListIteratorZRX<E> listIteratorZRX();
 *    基于索引的操作
 *      E get(int index);
 *      E set(int index,E element);
 *      void add(int index, E element);
 *      E remove(int index);
 *      int indexOf(Object o);
 *    另外的：块操作 变数组 排序 不可变类工场
 *
 *
 *
 * @param <E> 集合元素
 */

public abstract class AbstractListZRX<E> extends AbstractCollectionZRX<E> implements ListZRX<E>{

    /**
     * 唯一的一个构造器，只在子类的构造器中调用它
     */
    protected AbstractListZRX(){}

    /**
     * 初见吐槽：一定能添加成功？
     *
     * 用于尾加元素
     *
     */
    @Override
    public boolean add(E e){
        add(size(),e);
        return true;
    }

    // unfinished 。。。。
}
