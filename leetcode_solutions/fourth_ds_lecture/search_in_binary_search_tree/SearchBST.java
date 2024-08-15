package tasks.fourth_ds_lecture.search_in_binary_search_tree;

import tasks.fourth_ds_lecture.TreeNode;
/*
* problem link: https://leetcode.com/problems/search-in-a-binary-search-tree/
* */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        TreeNode node = root;
        while(node!=null){
            if(val < node.val)
                node = node.left;
            else if(val > node.val)
                node = node.right;
            else
                return node;
        }
        return null;
    }
}
