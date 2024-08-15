package tasks.fourth_ds_lecture.convert_sorted_list_to_binary_search_tree;

import tasks.fourth_ds_lecture.TreeNode;
import tasks.fourth_ds_lecture.ListNode;

public class SortedListToBST { // Actually AVL BST
    public TreeNode sortedListToBST(ListNode head) {
        if(head== null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        return balance(head, null);
    }

    private TreeNode balance(ListNode start, ListNode end){
        if(start == end)
            return null;

        ListNode mid = findMid(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left =  balance(start, mid);
        root.right = balance(mid.next, end);
        return root;
    }

    private ListNode findMid(ListNode start, ListNode end){
        ListNode slow = start, fast=start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
