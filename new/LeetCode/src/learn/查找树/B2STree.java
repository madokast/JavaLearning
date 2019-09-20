package learn.查找树;

import com.sun.source.tree.CompilationUnitTree;

import javax.xml.transform.Source;
import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B2STree<T extends Comparable<? super T>> {
    private int number; // 节点数
    private B2SNode<T> root; // 根

    public int size() {
        return number;
    }

    public T max() {
        return null;
    }

    private B2SNode<T> findMax(B2SNode<T> node) {
        if (node.rightChild == null)
            return node;
        else
            return findMax(node.rightChild);
    }

    public T min() {
        return null;
    }

    public T search(T key) {
        return null;
    }

    public boolean contains(T key) {
        return false;
    }

    public void add(T key) {
        this.root = insertByRecur(this.root, key);
    }

    private B2SNode<T> insertByRecur(B2SNode<T> node, T key) {
        // null?
        if (node == null) {
            this.number++;
            return new B2SNode<T>(key);
        } else {
            if (node.data.compareTo(key) > 0) {
                node.leftChild = insertByRecur(node.leftChild, key);
            } else if (node.data.compareTo(key) < 0) {
                node.rightChild = insertByRecur(node.rightChild, key);
            }
            return node;
        }
    }

    //最复杂的情况，删除中序前驱
    public void remove(T key) {
//        deleteByRecur(this.root, key);
        deleteByLoop(this.root, key);
    }

    //太美了吧.可惜是错的
    private B2SNode<T> deleteByRecur(B2SNode<T> node, T key) {
        B2SNode<T> s = null;
        if (node == null)
            return null;
        else if (key.compareTo(node.data) < 0) // left
            node.leftChild = deleteByRecur(node.leftChild, key);
        else if (key.compareTo(node.data) > 0) // right
            node.rightChild = deleteByRecur(node.rightChild, key);
            // 以下找到了要删除的元素
        else if (node.leftChild != null && node.rightChild != null) {
            s = findMax(node.leftChild);
            node.data = s.data;
            node.leftChild = deleteByRecur(node.leftChild, s.data);
        } else {
            if (node.leftChild == null) {
                node = node.rightChild;
            } else {
                node = node.leftChild;
            }
        }
        number--;

        return node;
    }

    private void deleteByLoop(B2SNode<T> node, T key) {
        if (node == null) return;
        else {
            B2SNode<T> father = null;
            int com = key.compareTo(node.data);
            while (com != 0) {
                father = node;
                if (com > 0) {
                    node = node.rightChild;
                } else {
                    node = node.leftChild;
                }
                if (node == null)
                    return;
                else
                    com = key.compareTo(node.data);
            }

            if (father == null) {
                if (node.leftChild != null && node.rightChild != null) {
                    B2SNode<T> del = node;

                    father = node;
                    node = node.leftChild;
                    boolean in = false;
                    while (node.rightChild != null) {
                        father = node;
                        node = node.rightChild;
                        in = true;
                    }
                    del.data = node.data;
                    if (in) {

                        father.rightChild = node.leftChild;
                    } else {
                        father.leftChild = node.leftChild;
                    }


                } else {
                    if (node.rightChild == null) {
                        root = root.leftChild;
                    } else {
                        root = root.rightChild;
                    }
                }

            } else {
                // node 待删
                if (node.leftChild != null && node.rightChild != null) {
                    B2SNode<T> del = node;
                    father = node;
                    node = node.leftChild;
                    boolean in = false;
                    while (node.rightChild != null) {
                        father = node;
                        node = node.rightChild;
                        in = true;
                    }
                    if (in) {
                        del.data = node.data;
                        father.rightChild = node.leftChild;
                    } else {
                        del.data = node.data;
                        father.leftChild = node.leftChild;
                    }

                    father.rightChild = node.leftChild;

                } else {
                    if (node.leftChild == null) {
                        if (father.leftChild != null && father.leftChild == node) {
                            father.leftChild = node.rightChild;
                        } else {
                            father.rightChild = node.rightChild;
                        }
                    } else {
                        if (father.leftChild != null && father.leftChild == node) {
                            father.leftChild = node.leftChild;
                        } else {
                            father.rightChild = node.leftChild;
                        }
                    }
                }
            }


            number--;

        }
    }

    //中序遍历。迭代实现 inOrderByRecursion
    public List<T> inOrder() {
        List<T> list = new ArrayList<>(size());
        inOrderByRecursion(root, list);
        return list;
    }

    private void inOrderByRecursion(B2SNode<T> root, List<T> list) {
        if (root != null) {
            inOrderByRecursion(root.leftChild, list);
            list.add(root.data);
            inOrderByRecursion(root.rightChild, list);
        }
    }

    public B2STree() {
    }

    public B2STree(B2SNode<T> root) {
        this.root = root;
    }

    public void printTree() {
        if (root != null) {
            root.print();
        }else {
            System.out.println("[]");
        }
    }

    @Override
    public String toString() {
        return "B2STree{" +
                "number=" + number +
                ", inOrder=" + inOrder() +
                '}';
    }

    public void addAll(T... arr) {
        Arrays.stream(arr).forEach(e -> add(e));
    }
}
