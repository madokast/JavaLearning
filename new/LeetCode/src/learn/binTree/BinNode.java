package learn.binTree;

public class BinNode<T> {
    //二叉树
    private T data;
    private BinNode<T> leftChild = null;
    private BinNode<T> rightChild = null;

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public BinNode() {
    }


    public BinNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
