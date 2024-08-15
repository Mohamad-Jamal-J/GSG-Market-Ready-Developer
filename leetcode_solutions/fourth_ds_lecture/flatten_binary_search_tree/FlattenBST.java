package tasks.fourth_ds_lecture.flatten_binary_search_tree;

import tasks.fourth_ds_lecture.TreeNode;

/*
 * problem link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * */
public class FlattenBST {
    public void flatten(TreeNode root) {
        root = preOrderFlatten(root, null);
    }
    private TreeNode preOrderFlatten(TreeNode node, TreeNode prev){
        // root, left, right.
        if(node==null)
            return prev;

        prev = preOrderFlatten(node.right, prev);
        prev = preOrderFlatten(node.left, prev);
        node.right = prev;
        node.left = null;
        return node;
    }
}
