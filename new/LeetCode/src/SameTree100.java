import com.sun.source.tree.CompilationUnitTree;

import java.util.Stack;

public class SameTree100 {
    public static void main(String[] args) {
        new SameTree100().test();
    }

    private void test() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
        int i =0 ;

        while ((!ps.empty())&&(!qs.empty())){
            System.out.println(i);
            i++;
            pi = ps.pop();
            qi = qs.pop();
            if(pi.val!=qi.val)
                return false;
            if(pi.left!=null){
                if(qi.left==null)
                    return false;
                ps.push(pi.left);
                qs.push(qi.left);
            }else if(qi.left!=null)
                return false;
            if(pi.right!= null){
                if(qi.right==null)
                    return false;
                ps.push(pi.right);
                qs.push(qi.right);
            }else if(qi.right!=null)
                return false;
        }

        if(ps.empty()&&qs.empty())
            return true;

        return false;
    }
}
