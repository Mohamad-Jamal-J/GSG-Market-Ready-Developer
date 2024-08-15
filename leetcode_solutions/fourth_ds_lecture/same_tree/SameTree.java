package tasks.fourth_ds_lecture.same_tree;
import tasks.fourth_ds_lecture.TreeNode;
/*
* problem link: https://leetcode.com/problems/same-tree/
* */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p==null || q==null || p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
