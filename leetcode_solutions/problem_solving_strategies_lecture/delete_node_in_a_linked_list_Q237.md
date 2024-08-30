## Problem
https://leetcode.com/problems/delete-node-in-a-linked-list/

## Java Code

```java
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
        node = node.next;
    }
}
```