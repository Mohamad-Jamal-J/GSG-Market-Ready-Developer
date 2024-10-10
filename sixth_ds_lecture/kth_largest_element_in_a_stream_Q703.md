## Problem
https://leetcode.com/problems/kth-largest-element-in-a-stream/

## Java Code

```java
class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for(int n: nums){
            add(n);
        }
    }
    
    public int add(int val) {
       if (heap.size() < k || val > heap.peek()) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
```