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
     * 一个点的bal = 右子树高度 - 左子树高度
     *      bal =  0 表示左右子树一样高
     *      bal =  1 表示右子树高一层
     *      bal = -1 表示左子树高一层
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

    public AVLTree() {
    }

    public AVLTree(T t) {
        this.t = t;
    }

    /**
     * 返回一个空avl树
     * @param <T> 结点值
     * @return 空avl树
     */
    public static <T extends Comparable<? super T>> AVLTree<T> getInstance(){
        return new AVLTree<>();
    }

    /**
     * 平衡树的插入
     * 1.像检索树一样，插入到叶子节点x
     * 2.然后沿插入的路径返回，修改x祖先的平衡因子（只有祖先的平衡因子发生改变）
     * 3.回溯中，一旦发现x的祖先失衡。即bal 1->2 或 -1->-2 通过旋转以该祖先为根的子树
     *
     * 四种旋转方式 LL LR RR RL
     * 设 p 是离插入结点最近的失衡祖先结点
     * 若p的左子树升高，bal从-1变为-2.采用LL 或LR旋转
     * LL插入节点为p的左子树的左儿子上，则为LL
     *
     * 若p的右子树增高，bal从1 到2。则采用RR RL旋转
     */
    public void add(T t){
        //非常好的序列19 30 43 16 13 18 37


    }
}
