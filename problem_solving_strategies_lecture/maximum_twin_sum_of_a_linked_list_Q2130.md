## Problem
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

## Java Code

```java
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        int max = 0;
        while(prev != null){
            max = Math.max(prev.val + slow.val, max);
            prev = prev.next; 
            slow = slow.next;
        }
        return max;
    }
}
```