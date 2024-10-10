package tasks.fourth_ds_lecture.delete_node_in_a_bst;


import tasks.fourth_ds_lecture.TreeNode;

/*
* problem link: https://leetcode.com/problems/delete-node-in-a-bst/
* */
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            TreeNode min = findMinRight(root);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }
    private TreeNode findMinRight(TreeNode node){
        // most left node in node.right
        node = node.right;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }
}
