package learn.AVL树;

import com.sun.source.tree.Tree;
import com.sun.source.tree.WhileLoopTree;

public class AVLTree<T extends Comparable<? super T>> {
    private int number;
    private AVLNode<T> root;

    public AVLTree() {
    }

    private int height(AVLNode<T> node){
        return (node==null)?0:node.getHeight();
    }

    private int max(int a,int b){
        return Math.max(a,b);
    }

    protected int balance(AVLNode<T> node){
        if(node==null)
            return 0;

        int hLeft = (node.getLeftChild()==null)?0:node.getLeftChild().getHeight();
        int hRight = (node.getRightChild()==null)?0:node.getRightChild().getHeight();

        node.setHeight(max(hLeft,hRight)+1);

        return height(node.getLeftChild())-height(node.getRightChild());
    }

    //平衡调整

    private AVLNode<T> tuneLL(AVLNode<T> p){
        AVLNode<T> pl = p.getLeftChild();
        p.setLeftChild(pl.getRightChild());
        pl.setRightChild(p);

        p.setHeight(max((p.getLeftChild()==null)?0:p.getLeftChild().getHeight(),
                (p.getRightChild()==null)?0:p.getRightChild().getHeight())+1);
        pl.setHeight(max((pl.getLeftChild()==null)?0:pl.getLeftChild().getHeight(),
                (pl.getRightChild()==null)?0:pl.getRightChild().getHeight())+1);

        return pl;
    }
    private AVLNode<T> tuneRR(AVLNode<T> p){
        AVLNode<T> pr = p.getRightChild();
        p.setRightChild(pr.getLeftChild());
        pr.setLeftChild(p);

        p.setHeight(max( (p.getLeftChild()==null)?0:p.getLeftChild().getHeight(),
                (p.getRightChild()==null)?0:p.getRightChild().getHeight())+1);
        pr.setHeight(max((pr.getLeftChild()==null)?0:pr.getLeftChild().getHeight(),
                (pr.getRightChild()==null)?0:pr.getRightChild().getHeight())+1);

        return pr;
    }
    private AVLNode<T> tuneLR(AVLNode<T> p){
        p.setLeftChild(tuneRR(p.getLeftChild()));
        p = tuneLL(p);
        return p;
    }
    private AVLNode<T> tuneRL(AVLNode<T> p){
        p.setRightChild(tuneLL(p.getRightChild()));
        p = tuneRR(p);
        return p;
    }

    public void add(T key){
        this.root = insert(this.root,key);
    }

    private AVLNode<T> insert(AVLNode<T> node,T key){
        if(node==null){
            node = new AVLNode<T>(key);
            number++;
            return node;
        }else if(key.compareTo(node.getData())<0){
            node.setLeftChild(insert(node.getLeftChild(),key));
        }else {
            node.setRightChild(insert(node.getRightChild(),key));
        }

        // balance
        if(balance(node)==2){
            if(balance(node.getLeftChild())==1){
                node = tuneLL(node);
            }else {
                node = tuneLR(node);
            }
        }
        if(balance(node)==-2){
            if(balance(node.getRightChild())==-1){
                System.out.println("RR");
                node = tuneRR(node);
            }else {
                node = tuneRL(node);
            }
        }

        return node;
    }



    private AVLNode<T> delete(AVLNode<T> node,T key){return null;}

    public void remove(T key){
        delete(this.root,key);
    }

    private AVLNode<T> findMax(AVLNode<T> node){
        if(node!=null){
            while (node.getRightChild()!=null)
                node = node.getRightChild();
        }
        return node;
    }

    private AVLNode<T> findMin(AVLNode<T> node){
        if(node!=null){
            while (node.getLeftChild()!=null)
                node = node.getLeftChild();
        }
        return node;
    }

    public int size(){
        return number;
    }

    public void printSelf(){
        if(root==null)
            System.out.println("[]");
        else
            root.print();

        System.out.println("-------------------");
    }

    private AVLNode<T> search(AVLNode<T> node,T key){
        if(node==null||key.equals(node.getData()))
            return node;
        else if(key.compareTo(node.getData())<0){
            return search(node.getLeftChild(),key);
        }else {
            return search(node.getRightChild(),key);
        }
    }

    public AVLNode<T> search(T key){
        return search(root,key);
    }

}
