package mooc1001660013.TreeMooc;

import com.sun.source.tree.CompilationUnitTree;

import javax.naming.InsufficientResourcesException;
import java.util.*;

/**
 * 二叉树
 *
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

    private class LayerElement<T> {
        int layer;
        T element;

        public LayerElement(int layer, T element) {
            this.layer = layer;
            this.element = element;
        }

        public String toString() {
            return "(" + element + "," + layer + ")";
        }

    }

    /**
     * 带层数的先根遍历
     *
     * @return 遍历列表
     */
    public List<LayerElement<T>> layerByPreRootTraversal() {
        List<LayerElement<T>> list = new ArrayList<>();
        preRootTraversal0(this, list, 1);
        return list;
    }


    /**
     * 后根遍历
     *
     * @return 遍历数组
     */
    public List<T> postRootTraversal() {
        List<T> list = new ArrayList<>();
        postRootTraversal0(this, list);
        return list;
    }

    /**
     * 后根遍历 内部处理
     *
     * @param bt   当前节点
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
     *
     * @return 遍历数组
     */
    public List<T> midRootTraversal() {
        List<T> list = new ArrayList<>();
        midRootTraversal0(this, list);
        return list;
    }

    /**
     * 中根遍历 内部处理
     *
     * @param bt   当前节点
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
     *
     * @return 遍历数组
     */
    public List<T> preRootTraversal() {
        List<T> list = new ArrayList<>();
        preRootTraversal0(this, list);
        return list;
    }

    /**
     * 先根遍历 内部处理
     *
     * @param bt   当前节点
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
     *
     * @param bt    当前节点
     * @param list  遍历数组
     * @param layer 当前高度
     */
    private void preRootTraversal0(final BiTree<T> bt, List<LayerElement<T>> list, int layer) {
        list.add(new LayerElement<T>(layer, bt.t));
        if (bt.left != null)
            preRootTraversal0(bt.left, list, layer + 1);
        if (bt.right != null)
            preRootTraversal0(bt.right, list, layer + 1);
    }

    /**
     * 静态方法 得到一个满二叉树
     *
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

    /**
     * 通过先序和中序序列构造二叉树
     * 递归操作
     * 不检查序列是否正确!
     * 不处理序列中有重复元素的问题!
     * <p>
     * 2019年7月11日 一次性写出来，我超级棒!!!!
     * tql tql
     *
     * @param pre 先序遍历序列
     * @param mid 后续遍历序列
     * @param <T> 二叉树元素
     * @return 构造出的二叉树
     */
    public static <T> BiTree<T> constructorFromPreAndMid(T[] pre, T[] mid) {
        if (pre.length != mid.length) {
            System.out.println("序列有误，长度不一致");
            System.exit(-1);
        }
        if (pre.length == 0)
            return null;

        BiTree<T> root = constructorFromPreAndMid(pre, 0, pre.length, mid, 0, mid.length);

        return root;
    }

    /**
     * 通过先序和中序序列构造二叉树 内部递归实现
     *
     * @param pre  先序遍历序列
     * @param preS 序列开头
     * @param preE 序列结尾+1
     * @param mid  中序遍历序列
     * @param midS 序列开头
     * @param midE 序列结尾+1
     * @param <T>  元素
     * @return 这个子序列的根
     */
    private static <T> BiTree<T> constructorFromPreAndMid(T[] pre, int preS, int preE, T[] mid, int midS, int midE) {
        //两段长度不一致
        if (preE - preS != midE - midS) {
            System.out.println("序列有误，可能出现重复元素");
            System.exit(-1);
        }

        //构造根
        T rootEle = pre[preS];
        BiTree<T> root = new BiTree<>(rootEle);

        //长度==1，及时返回
        if (preE - preS == 1)
            return root;

        //寻找中序遍历中的根位置
        int rootInMid = -1;
        for (int i = midS; i < midE; i++) {
            if (mid[i] == rootEle) {
                rootInMid = i;
                break;
            }
        }

        //没找到？
        if (rootInMid == -1) {
            System.out.println("序列有误，元素存在问题");
            System.exit(-1);
        }

        //找到了，求左右根元素的数目
        int numInLeft = rootInMid - midS;
        int numInRight = midE - rootInMid - 1;

        if (numInLeft > 0)
            root.left = constructorFromPreAndMid(pre, preS + 1, preS + 1 + numInLeft,
                    mid, midS, rootInMid);
        if (numInRight > 0)
            root.right = constructorFromPreAndMid(pre, preS + 1 + numInLeft, preE,
                    mid, rootInMid + 1, midE);

        return root;
    }

    /**
     * 建立检索树
     *
     * @param arr 序列
     * @return 树
     */
    public static BiTree searchTree(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        BiTree<Integer> root = new BiTree<>(arr[0]);

        if (arr.length == 1)
            return root;

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            BiTree<Integer> currentTree = root;

            while (true) {
                if (currentTree.t > num) {
                    //放到左边
                    if (currentTree.left == null) {
                        currentTree.left = new BiTree<>(num);
                        break;
                    } else {
                        currentTree = currentTree.left;
                        continue;
                    }
                } else if (currentTree.t < num) {
                    //放到右边
                    if (currentTree.right == null) {
                        currentTree.right = new BiTree<>(num);
                        break;
                    } else {
                        currentTree = currentTree.right;
                        continue;
                    }
                } else {
                    //相等 不做事
                    break;
                }


            }
        }

        return root;
    }

    /**
     * 检索树插入
     *
     * @param searchTree 树
     * @param num        元素
     */
    public static void insertIntoSearchTree(BiTree<Integer> searchTree, int num) {
        if (searchTree == null) {
            System.out.println("空树，无法插入");
        }

        BiTree<Integer> currentTree = searchTree;

        while (true) {
            if (currentTree.t > num) {
                //放到左边
                if (currentTree.left == null) {
                    currentTree.left = new BiTree<>(num);
                    break;
                } else {
                    currentTree = currentTree.left;
                    continue;
                }
            } else if (currentTree.t < num) {
                //放到右边
                if (currentTree.right == null) {
                    currentTree.right = new BiTree<>(num);
                    break;
                } else {
                    currentTree = currentTree.right;
                    continue;
                }
            } else {
                //相等 不做事
                break;
            }
        }
    }

    /**
     * 检索树/排序树 删除元素
     *
     * @param searchTree
     * @param num
     */
    public static void removeFromSearchTree(BiTree<Integer> searchTree, int num) {
        Objects.requireNonNull(searchTree);

        //查找要删除的元素
        BiTree<Integer> currentTree = searchTree;
        BiTree<Integer> fatherTree = null;
        boolean isLeft = true;
        while (true) {
            if (currentTree.t == num) {
                //找到
                break;
            }
            else if (currentTree.t > num) {
                //在左子树中
                if (currentTree.left == null) {
                    //元素不存在
                    return;
                } else {
                    fatherTree = currentTree;
                    currentTree = currentTree.left;
                    isLeft = true;
                    continue;
                }
            }
            else {
                //在右子树中
                if (currentTree.right == null) {
                    return;
                } else {
                    fatherTree = currentTree;
                    currentTree = currentTree.right;
                    isLeft = false;
                    continue;
                }
            }
        }

        //找到了，就是 currentTree 。开始删除
        //先遍历一下
        final List<Integer> list = currentTree.preRootTraversal();
        if(fatherTree==null){
            //如果就是根节点
            if(list.size()==1){
                searchTree.t=null;
                return;
            }else{
                searchTree.t=list.get(1);
                searchTree.left=null;
                searchTree.right=null;
                for (int i = 2 ; i < list.size(); i++) {
                    insertIntoSearchTree(searchTree,list.get(i));
                }
            }
        }
        else{
            //不是根节点
            if(isLeft){
                fatherTree.left=null;
                for (int i = 1 ; i < list.size(); i++) {
                    insertIntoSearchTree(searchTree,list.get(i));
                }
            }else{
                fatherTree.right=null;
                for (int i = 1 ; i < list.size(); i++) {
                    insertIntoSearchTree(searchTree,list.get(i));
                }
            }
        }
    }

    /**
     * 完美的打印二叉树
     */
    public void printTree() {
        //存放每一层的信息
        List<List<T>> floors = new ArrayList<>();
        //不递归了，入栈。三个栈，树栈、层数栈、层内房间/位置栈
        Stack<BiTree<T>> stackBiTree = new Stack<>();
        Stack<Integer> stackFloor = new Stack<>();
        Stack<Integer> stackRoom = new Stack<>();

        //根入栈
        stackBiTree.push(this);
        stackFloor.push(0);
        stackRoom.push(0);

        //开始遍历.先根遍历
        while (stackBiTree.size() > 0) {
            //取出
            final BiTree<T> tree = stackBiTree.pop();
            int floorNum = stackFloor.pop();
            int roomNum = stackRoom.pop();

            //判断此层是否建立好了
            if (floors.size() <= floorNum) {
                //没有建好。建立放入。
                // 因为遍历是先根遍历，所以不会出现建立的层，它的下一层却没有建好的情况
                List<T> floorList = new ArrayList<>();
                //建好后，全部设为空。因为知道这一层最多住几个人
                while (floorList.size() < Math.pow(2, floorNum)) {
                    floorList.add(null);
                }
                floors.add(floorList);
            }

            //正式放入
            final List<T> floor = floors.get(floorNum);
            floor.set(roomNum, tree.t);

            //之后遍历 左子树 和 右子树
            if (tree.right != null) {
                //入栈。同时还有这个树的位置信息
                stackBiTree.push(tree.right);
                stackFloor.push(floorNum + 1);
                stackRoom.push(roomNum * 2 + 1);
            }
            if (tree.left != null) {
                stackBiTree.push(tree.left);
                stackFloor.push(floorNum + 1);
                stackRoom.push(roomNum * 2);
            }
        }

        //遍历结束。尝试格式化打印出来
        for (List<T> floor : floors) {
            for (T t : floor) {
                if (t == null)
                    System.out.print("N ");
                else
                    System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}
