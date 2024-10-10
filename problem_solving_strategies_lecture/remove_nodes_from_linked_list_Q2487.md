## Problem

https://leetcode.com/problems/remove-nodes-from-linked-list/

## Java Code

```java
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;    
        }

        head = prev;
        curr = head.next;
        while(curr != null){
            if(prev.val > curr.val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }

        curr = head;
        prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```