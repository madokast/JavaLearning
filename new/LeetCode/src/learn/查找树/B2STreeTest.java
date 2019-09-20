package learn.查找树;

public class B2STreeTest {
    public static void main(String[] args) {
        final B2STree<Integer> tree = new B2STree<>();
        tree.addAll(12,8,15,6,10,13,19,9,14);

        tree.printTree();

        tree.remove(19);
        tree.printTree();

        tree.remove(10);
        tree.printTree();

        tree.remove(12);
        tree.printTree();

        tree.remove(15);
        tree.printTree();

        tree.remove(9);
        tree.printTree();

        tree.remove(8);
        tree.printTree();

        tree.remove(6);
        tree.printTree();

        tree.remove(13);
        tree.printTree();


        tree.remove(14);
        tree.printTree();

    }
}
