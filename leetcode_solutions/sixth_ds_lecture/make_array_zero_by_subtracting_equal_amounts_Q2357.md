## Problem
https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

## Java Code

### Using Priority Queue. 
```java
class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
            if(num != 0){
                heap.offer(num);
            }
        }
        int counter = 0;
        while(!heap.isEmpty()){
            counter++;
            int min = heap.poll();
            while(!heap.isEmpty() && heap.peek() == min){
                heap.poll();
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    nums[i] -= min;
                }
            }
        }
        return counter;
    }
}
```

### Using Set 
```java
class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num != 0){
                set.add(num);
            }
        }
        return set.size();
    }
}
```

### Using truth array
```java
class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] counts = new boolean[101];
        for(int num: nums){
            if(num != 0){
                counts[num] = true;
            }
        }
        int counter = 0;
        for(boolean b: counts){
            if(b){
                counter++;
            }
        }
        return counter;

    }
}
```