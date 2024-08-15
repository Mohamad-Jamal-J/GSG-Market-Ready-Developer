# Problem
- [Problem on LeetCode](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)

![submission.png](submission.png)


# Demo
Click on the video below or [here](https://drive.google.com/file/d/1MBHy-3H9QhqFoX3JJDS_eM-zqpknmHTe/view?usp=sharing) to watch a 27-seconds visualization of the solution:

[![bst.png](bst.png)](https://drive.google.com/file/d/1MBHy-3H9QhqFoX3JJDS_eM-zqpknmHTe/view?usp=sharing)

# Intuition
The data in the list is sorted in ascending order, so the middle-most node in the list divides the data into two parts (which are also sorted in ascending order).
This way we can use Divide & Conquer solution.

# Approach
- Find the middle node `mid` in the list `[start=head, end=null)`, and split the list into left and right halves:
    - Now the left child `mid.left` can be found at the middle of the left part: `[head, mid)`
    - And the right child `mid.right` can be found at the middle of the right part: `[mid.next, null)`
    - Repeat the above steps recursively until the entire list was converted into an AVL BST.

# Complexity
- Time Complexity: ***O(N Log N)***, `balance` method depends on `findMid` and dividing the data in half with each iteration, which means ***O(Log N)*** calls to `findMin` method.
And `finMid` method will iterate over a list of `N` nodes to find the middle node in it, this will take ***O(N)*** for each invocation. Overall, the T.C is ***O(N Log N)***.

- Space Complexity: ***O(Log N)***, for the recursive call stack, or ***O(1)*** when it's not considered. Note that the space of the new tree nodes created is not auxiliary, but the output.

# Code
## Java Sample
```java
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        return balance(head, null);
    }

    private TreeNode balance(ListNode start, ListNode end){ 
        // This method builds an AVL BST from a list by splitting the data in two halves, to be assigned as the future children of the middle-most node.
        if(start == end)
            return null;

        ListNode mid = findMid(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left =  balance(start, mid);
        root.right = balance(mid.next, end);
        return root;
    }

    private ListNode findMid(ListNode start, ListNode end){ // This method finds the middle-most node between two nodes.
        ListNode slow = start, fast=start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```
