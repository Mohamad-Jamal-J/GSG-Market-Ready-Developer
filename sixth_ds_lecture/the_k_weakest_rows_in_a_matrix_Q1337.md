## Problem
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix

## Java Code
### Using min heap, offering all elements to the heap, and polling k elements.
```java
public class Solution {
    Comparator<int[]> comparator = (x,y)-> x[1] == y[1]? x[0] - y[0]: x[1] - y[1];
    PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);
    public int[] kWeakestRows(int[][] mat, int k) {
        for(int i = 0; i < mat.length; i++){
            // Find number of ones using binary search.
            int left = 0, right = mat[i].length-1;
            while (left <= right) {
                int mid = (right + left)/2;
                if (mat[i][mid] == 1) {
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
            heap.offer(new int[]{i, left});
        }
        // Weakest k rows.
        int[] list = new int[k];
        int i = 0;
        while(k-- > 0){
            list[i++] = heap.poll()[0];
        }
        return list;
    }
}
```

### Using max heap, and maintaining k elements at a time in the heap.
```java
class Solution {
    Comparator<int[]> comparator = (x,y)-> x[1] == y[1]? y[0] - x[0]: y[1] - x[1];
    PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);
    public int[] kWeakestRows(int[][] mat, int k) {
        for(int i = 0; i < mat.length; i++){
            // Find number of ones using binary search.
            int left = 0, right = mat[i].length-1;
            while (left <= right) {
                int mid = (right + left)/2;
                if (mat[i][mid] == 1) {
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
            if(heap.size() < k || left < heap.peek()[1]){
                heap.offer(new int[]{i, left});
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        // Weakest k rows.
        int[] list = new int[k];
        while(!heap.isEmpty()){
            list[--k] = heap.poll()[0];
        }
        return list;
    }
}
```