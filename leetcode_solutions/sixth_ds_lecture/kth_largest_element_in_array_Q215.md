## Problem
https://leetcode.com/problems/kth-largest-element-in-an-array

## Java Code

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n:nums){
            if (heap.size() < k || n > heap.peek()) {
                heap.offer(n);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
```