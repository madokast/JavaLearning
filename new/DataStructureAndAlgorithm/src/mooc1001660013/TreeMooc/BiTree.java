package mooc1001660013.TreeMooc;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * @param <T> 节点存储元素
 */

public class BiTree<T> {
    public T t;
    public BiTree<T> left;
    public BiTree<T> right;

    public BiTree(T t) {
        this.t = t;
    }

    public String toString() {
        return t.toString();
    }

    private class LayerElement<T>{
        int layer;
        T element;

        public LayerElement(int layer, T element) {
            this.layer = layer;
            this.element = element;
        }
        public String toString(){
            return "("+element+","+layer+")";
        }

    }

    /**
     * 带层数的先根遍历
     * @return 遍历列表
     */
    public List<LayerElement<T>> layerByPreRootTraversal(){
        List<LayerElement<T>> list = new ArrayList<>();
        preRootTraversal0(this,list,1);
        return list;
    }


    /**
     * 后根遍历
     * @return 遍历数组
     */
    public List<T> postRootTraversal() {
        List<T> list = new ArrayList<>();
        postRootTraversal0(this, list);
        return list;
    }

    /**
     * 后根遍历 内部处理
     * @param bt 当前节点
     * @param list 遍历数组
     */
    private void postRootTraversal0(final BiTree<T> bt, List<T> list) {
        if (bt.left != null)
            postRootTraversal0(bt.left, list);
        if (bt.right != null)
            postRootTraversal0(bt.right, list);
        list.add(bt.t);
    }

    /**
     * 中根遍历
     * @return 遍历数组
     */
    public List<T> midRootTraversal() {
        List<T> list = new ArrayList<>();
        midRootTraversal0(this, list);
        return list;
    }

    /**
     * 中根遍历 内部处理
     * @param bt 当前节点
     * @param list 遍历数组
     */
    private void midRootTraversal0(final BiTree<T> bt, List<T> list) {
        if (bt.left != null)
            midRootTraversal0(bt.left, list);
        list.add(bt.t);
        if (bt.right != null)
            midRootTraversal0(bt.right, list);
    }


    /**
     * 先根遍历
     * @return 遍历数组
     */
    public List<T> preRootTraversal() {
        List<T> list = new ArrayList<>();
        preRootTraversal0(this, list);
        return list;
    }

    /**
     * 先根遍历 内部处理
     * @param bt 当前节点
     * @param list 遍历数组
     */
    private void preRootTraversal0(final BiTree<T> bt, List<T> list) {
        list.add(bt.t);
        if (bt.left != null)
            preRootTraversal0(bt.left, list);
        if (bt.right != null)
            preRootTraversal0(bt.right, list);
    }

    /**
     * 带层数 先根遍历 内部处理
     * @param bt 当前节点
     * @param list 遍历数组
     * @param layer 当前高度
     */
    private void preRootTraversal0(final BiTree<T> bt, List<LayerElement<T>> list,int layer){
        list.add(new LayerElement<T>(layer,bt.t));
        if (bt.left != null)
            preRootTraversal0(bt.left, list,layer+1);
        if (bt.right != null)
            preRootTraversal0(bt.right, list,layer+1);
    }

    /**
     * 静态方法 得到一个满二叉树
     * @param n 节点数
     * @return 满二叉树
     */
    public static BiTree fullBiTree(int n) {
        if (n <= 0)
            return null;
        BiTree[] biTrees = new BiTree[n + 1];
        biTrees[1] = new BiTree(1);
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                //需要增加的是左树
                biTrees[i / 2].left = new BiTree(i);
                biTrees[i] = biTrees[i / 2].left;
            } else {
                //需要增加的是右树
                biTrees[i / 2].right = new BiTree(i);
                biTrees[i] = biTrees[i / 2].right;
            }
        }
//        Arrays.stream(biTrees).forEach(System.out::println);
        return biTrees[1];
    }
}
