package mooc1001660013.TreeMooc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉检索树
 * @param <T>
 */

public class SearchTreeXXX<T extends Comparable<? super T>>{
    public T t;
    public SearchTreeXXX left;
    public SearchTreeXXX right;

    private final SearchTreeXXX<Comparable<Object>> dummy = new SearchTreeXXX<>(new Comparable<Object>() {
        @Override
        public int compareTo(Object o) {
            return -1;
        }
    });


    public SearchTreeXXX(T t) {
        this.t=t;
    }

    public SearchTreeXXX(){
        super();
    }

    /**
     * 二叉树插入对外接口
     * @param t 元素
     */
    public void insert(T t){
        if(this.t==null){
            this.t=t;
        }
        else{
            insert(this,t);
        }
    }

    /**
     * 二叉树插入内部实现
     * @param tree 当前考察的结点。一定非空
     * @param t 要插入的值
     * @param <T> 元素
     */
    private void insert(SearchTreeXXX<T> tree, T t){
        if(tree.t.compareTo(t)==-1){
            if(tree.right==null)
                tree.right = new SearchTreeXXX<>(t);
            else
                insert(tree.right,t);
        }
        else if(tree.t.compareTo(t)==1){
            if(tree.left==null)
                tree.left = new SearchTreeXXX<>(t);
            else
                insert(tree.left,t);
        }
    }

    /**
     * 删除结点
     *
     * 怎么删？是个大问题
     *
     * @param t 要删除的元素
     */
    public void remove(T t){

    }

    public void printTree(){
        //存放每一层的信息
        List<List<T>> floors = new ArrayList<>();
        //不递归了，入栈。三个栈，树栈、层数栈、层内房间/位置栈
        Stack<SearchTreeXXX<T>> stackBiTree = new Stack<>();
        Stack<Integer> stackFloor = new Stack<>();
        Stack<Integer> stackRoom = new Stack<>();

        //根入栈
        stackBiTree.push(this);
        stackFloor.push(0);
        stackRoom.push(0);

        //开始遍历.先根遍历
        while (stackBiTree.size() > 0) {
            //取出
            final SearchTreeXXX<T> tree = stackBiTree.pop();
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
