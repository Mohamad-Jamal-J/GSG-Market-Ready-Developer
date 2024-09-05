## Problem

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

## Java Code

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        boolean flag = false;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                flag = true;
                curr = curr.next;
            }
            if(flag){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
            flag = false;
        }
        return dummy.next;
    }
}
```