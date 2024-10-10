package tasks.fourth_ds_lecture.insert_into_bst;

import tasks.fourth_ds_lecture.TreeNode;
/*
*  problem link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
*
* */
public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode node = root;
        while(node != null){
            if(val < node.val){
                if(node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }
                node = node.left;
            } else if(val > node.val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    break;
                }
                node = node.right;
            }
        }
        return root;
    }
}
