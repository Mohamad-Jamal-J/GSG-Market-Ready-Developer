# Demo
[Check My Demo Here](https://drive.google.com/file/d/1Gnwwg34l_6Y97xOXnryCC0-5df_W_rTJ/view?usp=drive_link)

# Intuition
- `n`: position from right.
- We need to find a way to utilize the given `n`th position from list end, in order to find the position from list head.
- Assuming list length is **k**, then:
  - **k-n**: position from left where we should stop to delete the target node (given k>=n>=1).
  - **k-n+1**: position of the node to be deleted.
# Approach
Using two pointers (fast & slow) starting at list head (position 1).
- Move the fast pointer forward by `n` steps.
- Then move both pointers k-n-1 step forward (until the fast pointer is at k, and the slow pointer is at k-n).
- Now we can remove & skip the node at k-n+1.

# Complexity
- Time complexity:
  _**O(k):**_ where k is the size of the given list.

- Space complexity:
  _**O(1):**_ No extra space is needed, only two pointers are used.

# Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = head, slow = head;
      for(int i=0; i<n ;i++)
         fast = fast.next;

      if(fast==null)
         return head.next;

      while(fast.next!=null){
         fast = fast.next;
         slow = slow.next;
      }
      slow.next = slow.next.next;
      return head;
   }
}
```