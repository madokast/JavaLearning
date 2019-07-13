package mooc1001660013.TreeMooc;

import java.util.Comparator;

/**
 * 平衡树
 * ALV 数
 * 1. 书高度 h <= 1.45 log(n)  。。 n节点数
 * 2. 二叉树的左右子树高度差不超过1
 * 3. 二叉平衡树
 *
 * 平衡因子：表示节点的左右子树高度之差
 *
 * 平衡树 + 检索树
 * 二叉平衡检索树
 *
 * 怎么做到插入删除平衡？
 *      新增一个平衡因子域
 * @param <T>
 */

public class AVLTree<T extends Comparable<? super T>> {
    /**
     * 平衡因子。平衡时，每个结点的bal值只有三个取值 0 1 -1
     * 计算方法：
     * 一个点的bal = 左子树高度 - 右子树高度
     *      bal =  0 表示左右子树一样高
     *      bal =  1 表示左子树高一层
     *      bal = -1 表示右子树高一层
     *
     * 当插入删除时，bal变为其他值时，就需要调整使得子树平衡
     *
     * 如何调整？
     * 旋转法？
     */
    public int bal;
    public T t;
    public AVLTree left;
    public AVLTree right;
}
