package mooc1001660013.TreeMooc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 带有监督员的查找树
 */

public class SearchTree {
    int element;
    SearchTree left;
    SearchTree right;

    public void add(int element) {
        SearchTree currentTree = this;
        while (true) {
            if (currentTree.element < element) {
                if (currentTree.right == null) {
                    currentTree.right = new SearchTree(element);
                    return;
                } else {
                    currentTree = currentTree.right;
                }
            } else if (currentTree.element > element) {
                if (currentTree.left == null) {
                    currentTree.left = new SearchTree(element);
                    return;
                } else {
                    currentTree = currentTree.left;
                }
            } else//相等，不添加
                return;
        }
    }

    /**
     * 删除指定节点
     * 今天的BOSS!!
     *
     * 2019年7月12日 我成了！！！！
     *
     * @param element 要删除的节点
     */
    public void remove(int element) {
        //父节点
        SearchTree father = this;
        //当前查找结点
        SearchTree currentTree = this.right;
        //当前结点是不是父节点的右儿子
        boolean isLeft = false;

        //开始查找
        while (true) {
            if (currentTree.element < element) {
                if (currentTree.right == null) {
                    //本来应该进入右子树，但是却为空
                    System.out.println("要删除的结点不存在");
                    return;
                } else {
                    father = currentTree;
                    isLeft = false;
                    currentTree = currentTree.right;
                }
            } else if (currentTree.element > element) {
                if (currentTree.left == null) {
                    //本来应该进入左子树，但是却为空
                    System.out.println("要删除的结点不存在");
                    return;
                } else {
                    father = currentTree;
                    isLeft = true;
                    currentTree = currentTree.left;
                }
            } else {
                //找到结点
                break;
            }
        }

        //找到了结点。开始删除操作

        //分为八种情况
        if (currentTree.left == null || currentTree.right == null) {
            //要删除的结点的子树其中有一个为空
            if (currentTree.left == null) {
                //左节点为空。也隐含左右节点都为空的情况
                if (isLeft) {
                    //要删除的结点是父节点的左节点
                    father.left = currentTree.right;
                } else {
                    //要删除的结点是父节点的右
                    father.right = currentTree.right;
                }
            } else {
                //左节点不为空，则右节点一定为空
                if (isLeft) {
                    father.left = currentTree.left;
                } else {
                    father.right = currentTree.left;
                }
            }
        } else {
            //两个结点都不为空。需要找到中序序列中element的前驱
            SearchTree preTree = currentTree.left;
            if (preTree.right == null) {
                //如果preTree没有右节点，那么preTree就是currentTree的中序前驱
                //下面是精彩操作
                //让currentTree的值，变为preTree的值，然后删除preTree
                //即让currentTree的左节点指向preTree的左节点。因为preTree没有右节点，所以不用管
                currentTree.element = preTree.element;
                currentTree.left = preTree.left;
            }
            else{
                //如果preTree有右节点，需要继续寻找真正的中序前驱
                SearchTree fatherTreeOfPreTree = preTree;
                while(preTree.right!=null){
                    //寻找方法就是一直往右滑下去
                    fatherTreeOfPreTree = preTree;
                    preTree = preTree.right;
                }

                //找到了!
                //下面是更精彩的操作。
                //我要在anki里面背下来
                currentTree.element = preTree.element;
                fatherTreeOfPreTree.right = preTree.left;
            }
        }

    }


    /**
     * 带有监督员的查找树初始化
     *
     * @return 初始化查找树
     */
    public static SearchTree getInstance() {
        return new SearchTree(Integer.MIN_VALUE);
    }

    public SearchTree() {
    }

    public SearchTree(int element) {
        this.element = element;
    }

    /**
     * 打印二叉树，跳过了监督员
     */
    public void printTree() {
        //存放每一层的信息
        List<List<Integer>> floors = new ArrayList<>();
        //不递归了，入栈。三个栈，树栈、层数栈、层内房间/位置栈
        Stack<SearchTree> stackBiTree = new Stack<>();
        Stack<Integer> stackFloor = new Stack<>();
        Stack<Integer> stackRoom = new Stack<>();

        //根入栈
        stackBiTree.push(this.right);
        stackFloor.push(0);
        stackRoom.push(0);

        //开始遍历.先根遍历
        while (stackBiTree.size() > 0) {
            //取出
            final SearchTree tree = stackBiTree.pop();
            int floorNum = stackFloor.pop();
            int roomNum = stackRoom.pop();

            //判断此层是否建立好了
            if (floors.size() <= floorNum) {
                //没有建好。建立放入。
                // 因为遍历是先根遍历，所以不会出现建立的层，它的下一层却没有建好的情况
                List<Integer> floorList = new ArrayList<>();
                //建好后，全部设为空。因为知道这一层最多住几个人
                while (floorList.size() < Math.pow(2, floorNum)) {
                    floorList.add(null);
                }
                floors.add(floorList);
            }

            //正式放入
            final List<Integer> floor = floors.get(floorNum);
            floor.set(roomNum, tree.element);

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
        for (List<Integer> floor : floors) {
            for (Integer t : floor) {
                if (t == null)
                    System.out.print("N ");
                else
                    System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}
