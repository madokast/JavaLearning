import java.util.Stack;

public class SymmetricTree101 {
    //Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //
    //For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //
    //
    //But the following [1,2,2,null,3,null,3] is not:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return isSameTree(root.left,root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null)
            return p==q;

        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        ps.push(p);
        qs.push(q);

        TreeNode pi;
        TreeNode qi;

        while ((!ps.empty())&&(!qs.empty())){
            pi = ps.pop();
            qi = qs.pop();
            if(pi.val!=qi.val)
                return false;
            if(pi.left!=null){
                if(qi.right==null)
                    return false;
                ps.push(pi.left);
                qs.push(qi.right);
            }else if(qi.right!=null)
                return false;
            if(pi.right!= null){
                if(qi.left==null)
                    return false;
                ps.push(pi.right);
                qs.push(qi.left);
            }else if(qi.left!=null)
                return false;
        }

        if(ps.empty()&&qs.empty())
            return true;

        return false;
    }

}
