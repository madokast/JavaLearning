import tools.TreeNode;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class MaximumDepthofBinaryTree104 {
    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        ArrayList<Integer> list = new ArrayList<>();

        postorderTraversal2(root, list, 0);
        int maxDeep = 0;
        for (int t : list) {
            if (t > maxDeep)
                maxDeep = t;
        }
        return maxDeep;
    }

    private void postorderTraversal2(TreeNode t, ArrayList<Integer> list, int deep) {
        deep++;
        if (t.left != null)
            postorderTraversal2(t.left, list, deep);
        if (t.right != null)
            postorderTraversal2(t.right, list, deep);
        list.add(deep);
    }
}
