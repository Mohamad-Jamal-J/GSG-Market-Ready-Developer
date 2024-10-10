## Problem

https://leetcode.com/problems/linked-list-cycle-ii/

## Java Code

### Solution 1: Using HashSet
```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null){
            if(set.contains(curr)){
                return curr;
            }else{
                set.add(curr);
            }
            curr = curr.next;
        }
        return null;
    }
}
```
### Solution 2: Using Constant Space
This Solution was inspired by this article: https://algo.monster/liteproblems/142
```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ // this detects a cycle, but it doesn't tell us the cycle entrance.
                while(head != slow){ // the head and slow are destined to meet at the cycle entrance if they move at the same pace.
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
```