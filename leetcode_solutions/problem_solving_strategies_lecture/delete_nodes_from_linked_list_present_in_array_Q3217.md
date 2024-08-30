## Problem

https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

## Java Code

### Solution 1: Using HashSet
Time Complexity: `Max(_O(M)_, Amortized _O(N)_)`, where `N` is list size, and `M` is array size.
Space Complexity: O(M) where M is the HashSet size (it contains the unique elements from the array, but in worst case all of them might be unique).
```java
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        while(head != null && set.contains(head.val)){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode curr = head.next, prev = head;
        while(curr != null){
            if(set.contains(curr.val)){
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
        }        
        return head;
    }
}
```

### Solution 2: Using Array of Truths
```java
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] seen = new boolean[100001];

        for(int n:nums){
            seen[n] = true;
        }
        while(head != null && seen[head.val]){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode curr = head.next, prev = head;
        while(curr != null){
            if(seen[curr.val]){
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
        }        
        return head;
    }
}
```
### Solution 3: Improvement on the Array of Truths Solution, Using Max Value.
```java
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for(int n:nums){
            if(n > max){
                max = n;
            }
        }
        boolean[] seen = new boolean[max+1];

        for(int n:nums){
            seen[n] = true;
        }
        while(head != null && head.val <= max && seen[head.val]){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode curr = head.next, prev = head;
        while(curr != null){
            if(curr.val <= max && seen[curr.val]){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }        
        return head;
    }
}
```