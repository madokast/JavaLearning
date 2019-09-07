package learn.binTree;

public class Test {
    public static void main(String[] args) {
        final BinNode<Integer> root = BinTreeUtils.initBinTree(10);
        BinTreeUtils.addLeftChild(root,5);
        BinTreeUtils.addRightChild(root,15);
        BinTreeUtils.addLeftChild(root.getRightChild(),12);

        System.out.println(BinTreeUtils.traverse先序遍历递归(root));

        System.out.println(BinTreeUtils.traverse层次遍历(root));
    }
}
