package MyCollection;

/**
 * list迭代器，可以任意方向移动
 * 可以迭代中修改元素
 * 可以获得迭代器当前位置
 * “它的光标位置 始终位于调用 previous() 所返回的元素和调用 next() 所返回的元素之间。”
 * “长度为 n 的列表的迭代器有 n+1 个可能的指针位置”
 *                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 * cursor positions:  ^            ^            ^            ^                  ^
 * 但是remove和set操作和上述光标位置无关，他们操作于最后一次 next() 或者 previous() 得到的元素
 *
 *
 * 附录：IteratorZRX中的接口
 *  boolean hasNext();
 *  E next();
 *  default void remove()
 *
 * 新增的接口：
 *  boolean hasPrevious();
 *  E previous();
 *  int nextIndex();
 *  int previousIndex();
 *  void set(E e);
 *  void add(E e);
 *
 * @param <E> 元素
 * @version 2019.5.15
 */

public interface ListIteratorZRX<E> extends IteratorZRX<E> {
    @Override
    boolean hasNext();

    /**
     * @return 返回光标右边的元素，然后光标右移1位
     */
    @Override
    E next();

    /**
     * @return 如果以逆向遍历列表，列表迭代器有多个元素，则返回 true。
     */
    boolean hasPrevious();

    /**
     * @return 返回光标左边的元素，然后光标左移1位
     */
    E previous();

    /**
     * @return 返回光标右边的元素的索引，即next()得到的元素的位置
     */
    int nextIndex();

    /**
     * @return 返回光标左边的元素的索引，即previous()得到的元素的位置
     */
    int previousIndex();

    @Override @Deprecated
    default void remove(){throw new UnsupportedOperationException("remove");}

    @Deprecated
    default void set(E e){throw new UnsupportedOperationException("set");}

    @Deprecated
    default void add(E e){throw new UnsupportedOperationException("add");}
}

//原版使用示例
//        List list = new ArrayList();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println("list.size() = " + list.size());//list.size() = 4
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i list.get(i) = "+ i +" " + list.get(i));
//            //i list.get(i) = 0 0
//            //i list.get(i) = 1 1
//            //i list.get(i) = 2 2
//            //i list.get(i) = 3 3
//        }
//
//        ListIterator listIterator = list.listIterator();
//        System.out.println("listIterator.next() = " + listIterator.next());//0
//        System.out.println("listIterator.next() = " + listIterator.next());//1
//
//        //      0   1   2   3
//        //    |  |   |   |   |
//
//        System.out.println("listIterator.nextIndex() = " + listIterator.nextIndex());//2
//        System.out.println("listIterator.previousIndex() = " + listIterator.previousIndex());//1