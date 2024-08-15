package tasks.fourth_ds_lecture.symmetric_tree;
import tasks.fourth_ds_lecture.same_tree.SameTree;
import tasks.fourth_ds_lecture.TreeNode;

/*
* problem link: https://leetcode.com/problems/symmetric-tree/
* */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return SameTree.isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p==null || q==null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
