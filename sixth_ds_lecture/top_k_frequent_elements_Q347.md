## Problem
https://leetcode.com/problems/top-k-frequent-elements/

## Java Code

```java
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    public int[] topKFrequent(int[] nums, int k) {
        // Find the frequency of each element.
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        // Add the elements to the heap (based on their frequencies), but at any point, 
        // only K elements are allowed inside the heap.
        for (int n: map.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // By this line, the heap will contain the K most frequent elements.
        int[] result = new int[k];
        while (!heap.isEmpty()) {
            result[--k] = heap.poll();
        }
        return result;
    }
}
```