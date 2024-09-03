## Problem

https://leetcode.com/problems/swap-nodes-in-pairs/

## Java Code

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head, prev = null;
        head = head.next;
        while(curr != null && curr.next != null){
            ListNode nextPair = curr.next.next;
            curr.next.next = curr;
            
            if(prev != null){
                prev.next = curr.next;
            }
            curr.next = nextPair;
            prev = curr;
            curr = nextPair; 
        }
        return head;
    }
}
```