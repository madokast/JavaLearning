package learn.AVL树;

import java.util.Objects;

public class AVLNode<T extends Comparable<? super T>> implements Comparable<AVLNode<T>>,TreePrintable<T> {
    private int height; // 叶子节点的高度为 1
    private T data;
    private AVLNode<T> leftChild, rightChild;

    public AVLNode(T data) {
        this.data = data;
        height = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AVLNode<?> avlNode = (AVLNode<?>) o;
        return Objects.equals(data, avlNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(AVLNode<T> o) {
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
}
