package mooc1001660013.TreeMooc;

public class Test {
    public static void main(String[] args) {
        traversal();
        System.out.println("------------");
        lateyTraversal();
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
