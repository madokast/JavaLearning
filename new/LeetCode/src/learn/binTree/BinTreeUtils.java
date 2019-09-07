package learn.binTree;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinTreeUtils {
    public static <T> BinNode<T> initBinTree() {
        return new BinNode<T>();
    }

    public static <T> BinNode<T> initBinTree(T data) {
        return new BinNode<T>(data);
    }

    public static <T> void addLeftChild(BinNode<T> tree, T data) {
        tree.setLeftChild(initBinTree(data));
    }

    public static <T> void addRightChild(BinNode<T> tree, T data) {
        tree.setRightChild(initBinTree(data));
    }

    public static <T> List<T> traverse层次遍历(BinNode<T> root){
        Queue<BinNode<T>> queue = new ArrayDeque<>();
        List<T> list = new ArrayList<>();
        if(root!=null){
            queue.add(root);
            while (!queue.isEmpty()){
                final BinNode<T> node = queue.remove();
                list.add(node.getData());
                if(node.hasLeftChild()) queue.add(node.getLeftChild());
                if(node.hasRightChild()) queue.add(node.getRightChild());
            }
        }

        return list;
    }

    public static <T> List<T> traverse先序遍历递归(BinNode<T> root) {
        List<T> list = new ArrayList<>();
        if(root!=null)
            traverse先序遍历递归0(root, list);

        return list;
    }

    private static <T> void traverse先序遍历递归0(BinNode<T> tree, List<T> list) {
        if (tree.hasLeftChild()) traverse先序遍历递归0(tree.getLeftChild(), list);
        list.add(tree.getData());
        if (tree.hasRightChild()) traverse先序遍历递归0(tree.getRightChild(), list);
    }
}
