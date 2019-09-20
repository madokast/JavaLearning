package learn.AVL树;

public class AVLTreeTest {
    public static void main(String[] args) {
        final AVLTree<Integer> tree = new AVLTree<Integer>();

        tree.add(13);
        tree.printSelf();
        tree.add(24);
        tree.printSelf();
        tree.add(37);
        tree.printSelf();
        tree.add(90);
        tree.printSelf();
        tree.add(53);
        tree.printSelf();
    }
}
