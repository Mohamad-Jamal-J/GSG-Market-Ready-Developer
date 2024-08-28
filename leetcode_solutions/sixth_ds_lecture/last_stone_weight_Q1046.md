## Problem
https://leetcode.com/problems/last-stone-weight/

## Java Code
### Using Priority Queue (max heap).
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x,y) -> y - x);

        for(int stone: stones){
            heap.offer(stone);
        }

        while(heap.size() >= 2){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            stone1 = stone1 - stone2;
            if( stone1 != 0){
                heap.offer(stone1);
            }
        }
        return heap.isEmpty()? 0: heap.poll();
    }
}
```

### Using Counting Sort
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] counts = new int[1001];
        for(int stone: stones){
            counts[stone]++;
        }

        for(int i = counts.length-1; i >= 0 ; i--){
            while(counts[i] > 0){
                int j = i;
                counts[i]--;

                while(j > 0 && counts[j] == 0){
                    j--;
                }
                if(j == 0){
                    return i;
                }
                counts[j]--;
                int smashed = i -j;
                if(smashed > 0){
                    counts[smashed]++;
                }
            }
        }
        return 0;
    }
}
```
### Using Arrays.sort method.
#### Note there was a constraint on the given array size to be less than 31, so sorting isn't a problem.
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int i = stones.length - 1;
        int j = i - 1;
        while(j >= 0){
            if(stones[j] == 0){
                return stones[i];
            }else{
                int smashed = stones[i] - stones[j];
                stones[i] = 0;
                stones[j] = smashed;
                Arrays.sort(stones);
            }
        }
        return stones[0];
    }
}
```