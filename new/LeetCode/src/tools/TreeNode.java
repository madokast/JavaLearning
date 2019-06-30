package tools;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        if (root == null)
            return null;

        List<Integer> list = new ArrayList<>();
        List<Integer> dlist = new ArrayList<>();
        inorderTraversal0(root, list);
        inorderTraversal0(root,dlist,0);

        List<List<Integer>> listList = new ArrayList<>(Tools.maxList(dlist)-1);
        System.out.println(dlist);
        for (int i = 0; i < Tools.maxList(dlist); i++) {
            listList.add(new ArrayList<>());
        }

        for (int i = 0; i < list.size(); i++) {
            int deep = dlist.get(i);
            int val = list.get(i);

            listList.get(deep-1).add(val);
        }
        return listList;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal2(root, list, 0);

        return Tools.maxList(list);

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        postorderTraversal0(root, list);
        return list;
    }

    private static void postorderTraversal2(TreeNode t, List list, int deep) {
        deep++;
        if (t.left != null)
            postorderTraversal2(t.left, list, deep);
        if (t.right != null)
            postorderTraversal2(t.right, list, deep);
        list.add(deep);
    }

    private static void postorderTraversal0(TreeNode t, List list) {
        if (t.left != null)
            postorderTraversal0(t.left, list);
        if (t.right != null)
            postorderTraversal0(t.right, list);
        list.add(t.val);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        preorderTraversal0(root, list);
        return list;
    }

    private static void preorderTraversal0(TreeNode t, List list) {
        if (t.left != null)
            preorderTraversal0(t.left, list);
        list.add(t.val);
        if (t.right != null)
            preorderTraversal0(t.right, list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        inorderTraversal0(root, list);
        return list;
    }

    private static void inorderTraversal0(TreeNode t, List list) {
        list.add(t.val);
        if (t.left != null)
            inorderTraversal0(t.left, list);
        if (t.right != null)
            inorderTraversal0(t.right, list);
    }

    private static void inorderTraversal0(TreeNode t, List list, int deep) {
        deep++;
        list.add(deep);
        if (t.left != null)
            inorderTraversal0(t.left, list, deep);
        if (t.right != null)
            inorderTraversal0(t.right, list, deep);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(inorderTraversal(root));
        System.out.println(preorderTraversal(root));
        System.out.println(postorderTraversal(root));
        System.out.println(maxDepth(root));
        List list = levelOrder(root);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
