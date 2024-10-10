## Problem
https://leetcode.com/problems/reorder-list/

## Java Code

```java
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // find middle-most node
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // add the second half of the list to a stack
        ListNode curr = slow;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        // insert the stack tops after each node, starting from head, to slow
        curr = head;
        while(curr != slow){
            ListNode next = curr.next;
            ListNode last = stack.pop();
            curr.next = last;
            last.next = next;
            curr = next;
        }
        slow.next = null;
    }
}
```