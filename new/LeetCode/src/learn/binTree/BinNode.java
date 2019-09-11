package learn.binTree;

public class BinNode<T> implements TreePrintable<T> {
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

    @Override
    //注释见接口
    public String get(int i) {
        if (i == 1) {
            //自己
            return getData().toString();
        } else {
            //处于层数
            int floorNumber = (int) (Math.log10(i) / Math.log10(2)) + 1;
            if (i >= 1 << (floorNumber - 1)
                    &&
                    i < ((1 << (floorNumber - 1)) + (1 << (floorNumber - 2)))) {
                if (getLeftChild() == null) {
                    return "null";
                } else {
                    return getLeftChild().get(i - (1 << (floorNumber - 2)));
                }

            } else {
                if (getRightChild() == null) {
                    return "null";
                } else {
                    return getRightChild().get(i - (1 << (floorNumber - 1)));
                }
            }
        }
    }

    @Override
    /**
     * 测试通过!!
     * 第一层=1
     */
    public int getFloorNumber() {
        if (getData() == null)
            return 0;
        else {
            int leftFloor = 0;
            int rightFloor = 0;
            if (getLeftChild() != null) {
                leftFloor = getLeftChild().getFloorNumber();
            }
            if (getRightChild() != null) {
                rightFloor = getRightChild().getFloorNumber();
            }


            return Math.max(leftFloor, rightFloor) + 1;
        }
    }
}
