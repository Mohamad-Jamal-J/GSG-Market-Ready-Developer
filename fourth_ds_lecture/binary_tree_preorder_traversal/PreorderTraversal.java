package tasks.fourth_ds_lecture.binary_tree_preorder_traversal;

import tasks.fourth_ds_lecture.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* problem link: https://leetcode.com/problems/binary-tree-preorder-traversal
* */
public class PreorderTraversal {
    List<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // root, left, right.
        if(root == null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left !=null)
                stack.push(node.left);
        }
        return list;
    }
}
