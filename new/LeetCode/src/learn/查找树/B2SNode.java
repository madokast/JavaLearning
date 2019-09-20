package learn.查找树;

import java.util.Objects;

public class B2SNode<T extends Comparable<? super T>> implements Comparable<B2SNode<T>> ,TreePrintable {
    protected T data;  //数据
    protected B2SNode<T> leftChild,rightChild; //左右孩子

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B2SNode<?> b2SNode = (B2SNode<?>) o;
        return Objects.equals(data, b2SNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public B2SNode() {}

    public B2SNode(T data) {
        this.data = data;
    }

    public B2SNode(T data, B2SNode<T> leftChild, B2SNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(B2SNode<T> o) {
        return data.compareTo(o.data);
    }

    @Override
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public B2SNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(B2SNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public B2SNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(B2SNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
