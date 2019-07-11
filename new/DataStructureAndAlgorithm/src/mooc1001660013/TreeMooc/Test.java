package mooc1001660013.TreeMooc;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        traversal();
//        lateyTraversal();
//        printTree();
//        constructorFromPreAndMidTest();
        searchTreeTest();
    }
    private static void searchTreeTest(){
        final BiTree searchTree = BiTree.searchTree(new int[]{1, 2, 3, 4});
        searchTree.printTree();
        System.out.println("---------------------");
        BiTree.insertIntoSearchTree(searchTree,-1);
        searchTree.printTree();
        BiTree.insertIntoSearchTree(searchTree,0);
        searchTree.printTree();
//        BiTree.removeFromSearchTree(searchTree,4);
        BiTree.removeFromSearchTree(searchTree,1);
        searchTree.printTree();

    }

    private static void constructorFromPreAndMidTest() {
        BiTree.constructorFromPreAndMid(new Integer[]{1,2,3,4},new Integer[]{4,3,2,1}).printTree();
        System.out.println("--------------------");
        BiTree.constructorFromPreAndMid(
                new Character[]{'A','B','C','D','E','F','G','H'},
                new Character[]{'B','D','C','E','A','G','F','H'}
        ).printTree();
    }

    private static void printTree() {
        BiTree biTree = BiTree.fullBiTree(9);
        biTree.printTree();
        System.out.println("----------------");

        BiTree<Character> biTree1 = new BiTree('A');
        biTree1.right = new BiTree('B');
        biTree1.right.right = new BiTree('C');
        biTree1.right.right.right = new BiTree('D');
        biTree1.right.right.right.right = new BiTree('E');
        biTree1.right.right.right.right.left = new BiTree('F');
        biTree1.right.right.right.right.right = new BiTree('G');
        biTree1.printTree();
    }

    private static void lateyTraversal(){
        BiTree biTree = BiTree.fullBiTree(7);
        System.out.println("biTree.preRootTraversal() = " + biTree.preRootTraversal());
        System.out.println("biTree.layerByPreRootTraversal() = " + biTree.layerByPreRootTraversal());
    }

    private static void traversal(){
        BiTree biTree = BiTree.fullBiTree(7);
        System.out.println("biTree.preRootTraversal() = " + biTree.preRootTraversal());
        System.out.println("biTree.midRootTraversal() = " + biTree.midRootTraversal());
        System.out.println("biTree.postRootTraversal() = " + biTree.postRootTraversal());
        //biTree.preRootTraversal() = [1, 2, 4, 5, 3, 6, 7]
        //biTree.midRootTraversal() = [4, 2, 5, 1, 6, 3, 7]
        //biTree.postRootTraversal() = [4, 5, 2, 6, 7, 3, 1]
    }
}
