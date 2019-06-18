package mooc1001660013.ListSeriesMooc;

public interface ListMooc {
    /**
     * 元素数目
     * @return 元素数目
     */
    int size();

    /**
     * 获得i位置的元素
     * @param i 位置
     * @return i位置的元素
     */
    int get(int i);

    /**
     * 讲i位置的元素设为e
     * 效率极其低下
     * @param e 元素
     * @param i 位置
     * @return 是否设置成功
     */
    @Deprecated
    default boolean set(int e,int i){//inefficient
        boolean delete = delete(i);
        boolean insert = insert(e,i);
        return delete&&insert;
    }

    /**
     * i位置插入元素，后面的元素后移一位
     * @param e 元素
     * @param i 位置
     * @return 是否插入成功
     */
    boolean insert(int e, int i);

    /**
     * 即add(int e)
     * @param e 元素
     * @return 是否插入成功
     */
    default boolean insert(int e) {
        return insert(e, size());
    }

    /**
     * 删除i位置的元素
     * @param i 位置
     * @return 是否删除成功
     */
    boolean delete(int i);

    /**
     * 移除最末尾的元素
     * @return 是否移除成功
     */
    default boolean delete() {
        return delete(size() - 1);
    }

    /**
     * 顺序查找
     * 查找元素e出现的的位置，若有多个，返回最近的一个，没有返回-1
     * @param e 要查找的元素
     * @return 位置
     */
    default int search(int e) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == e)
                return i;
        }
        return -1;
    }

    /**
     * 检查表是由有序
     * @return 是否有序
     */
    default boolean isSorted() {
        for (int i = 0; i < size() - 1; i++) {
            if (get(i) > get(i + 1))
                return false;
        }
        return true;
    }

    /**
     * 二分查找
     * 需要保证表有序
     * @param e 查找元素
     * @return 位置
     */
    default int searchBinary(int e){
        if (!isSorted()){
            System.err.println("元素无序 无法二分查找");
            return -1;
        }

        int left = 0;
        int right = size()-1;
        int middle;
        while (left<=right){
            middle = (right+left)/2;
            if(e==get(middle))
                return middle;
            else if(e>get(middle))
                left = middle+1;
            else
                right = middle-1;
        }

        return -1;
    }

    /**
     * 交换元素
     * @param i 位置i
     * @param j 位置j
     * @return 是否交换成功
     */
    default boolean swap(int i,int j){
        int ei = get(i);
        int ej = get(j);
        boolean seti = set(ei,j);
        boolean setj = set(ej,i);
        return seti&&setj;
    }

    /**
     * 冒泡排序
     */
    default void sortBubble(){
        if(isSorted())
            return;

        boolean change;
        do{
            change = false;
            for (int i = 0; i < size()-1; i++) {
                if(get(i)>get(i+1)){
                    swap(i,i+1);
                    change = true;
                }
            }
        }while (change);
    }

    /**
     * 期望重写此方法，返回[1,2,3]形式字符串
     * @return 字符串
     */
    String toString();

    /**
     * 打印元素
     */
    default void print() {
        System.out.println(toString());
    }
}
