package mooc1001660013.TreeMooc;

public class Test {
    public static void main(String[] args) {
//        traversal();
//        lateyTraversal();
//        printTree();
//        constructorFromPreAndMidTest();
//        searchTreeTest();
//        compare();
//        searchTreeTest2();
//        searchTreeTest3();
        searchTreeTest4();
    }

    private static void searchTreeTest4() {
        final SearchTree searchTree = SearchTree.getInstance();
        searchTree.add(63);
        searchTree.add(45);
        searchTree.add(72);

        searchTree.add(40);
        searchTree.add(53);
        searchTree.add(81);

        searchTree.add(30);
        searchTree.add(51);
        searchTree.add(60);
        searchTree.add(77);
        searchTree.add(95);

        searchTree.add(23);
        searchTree.add(35);
        searchTree.add(48);
        searchTree.add(55);
        searchTree.add(57);

        searchTree.printTree();

        System.out.println("-------------------------删除叶子结点48");
        searchTree.remove(48);
        searchTree.printTree();

        System.out.println("-------------------------只有一个子树的结点60");
        searchTree.remove(60);
        searchTree.printTree();

        System.out.println("-------------------------删除有两个子树的结点45");
        searchTree.remove(45);
        searchTree.printTree();

        System.out.println("-------------------------删除有两个子树的结点63 最复杂");
        searchTree.remove(63);
        searchTree.printTree();

    }

    private static void searchTreeTest3() {
//        SearchTree root = new SearchTree(10);
//        root.printTree();
    }

    private static void searchTreeTest2() {
        SearchTreeXXX<Integer> searchTree = new SearchTreeXXX<>();
        searchTree.printTree();
        searchTree.insert(1);
        searchTree.insert(2);
        searchTree.insert(-1);

        searchTree.printTree();
        System.out.println("searchTree.t = " + searchTree.t);
        System.out.println("searchTree.left.t = " + searchTree.left.t);
        System.out.println("searchTree.right.t = " + searchTree.right.t);
    }

    private static void compare() {
        Integer a = 1;
        Integer b = 2;

        System.out.println("a.compareTo(b) = " + a.compareTo(b));
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
