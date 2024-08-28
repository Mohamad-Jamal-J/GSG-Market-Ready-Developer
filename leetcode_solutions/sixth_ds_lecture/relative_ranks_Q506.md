## Problem
https://leetcode.com/problems/relative-ranks/

## Java Code
### Using max heap (priority queue).
```java
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((x,y) -> y[1] - x[1]);
        for(int i = 0; i < score.length; i++){
            heap.offer(new Integer[]{i, score[i]});
        }

        String[] list = new String[score.length];
        int counter = 0;
        while(!heap.isEmpty()){
            Integer[] rank = heap.poll();
            String r;
            if(counter == 0){
                r = "Gold Medal";
            }else if(counter == 1){
                r = "Silver Medal";
            }else if(counter == 2){
                r = "Bronze Medal";
            }else{
                r = ""+(counter+1);
            }
            list[rank[0]] = r;
            counter++;
        }
        return list;
    }
}
```

### Using 2D array and Arrays.sort method.
```java
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[][] scores = new int[score.length][2];
        for(int i = 0; i < score.length; i++){
            scores[i] = new int[]{i, score[i]};
        }
        Arrays.sort(scores, (a, b) -> Integer.compare(b[1], a[1]));
        String[] list = new String[score.length];
        int counter = 0;

        for(int[] rank: scores){
            String r;
            if(counter == 0){
                r = "Gold Medal";
            }else if(counter == 1){
                r = "Silver Medal";
            }else if(counter == 2){
                r = "Bronze Medal";
            }else{
                r = ""+(counter+1);
            }
            list[rank[0]] = r;
            counter++;
        }
        return list;
    }
}
```
### Using HashMap and priority queue.
```java
class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((x,y) -> map.get(y) - map.get(x));
        for(int i = 0; i < score.length; i++){
            map.put(i, score[i]);
        }

        for(int n: map.keySet()){
            heap.offer(n);
        }

        String[] list = new String[score.length];
        int counter = 0;
        while(!heap.isEmpty()){
            int rank = heap.poll();
            String r;
            if(counter == 0){
                r = "Gold Medal";
            }else if(counter == 1){
                r = "Silver Medal";
            }else if(counter == 2){
                r = "Bronze Medal";
            }else{
                r = ""+(counter+1);
            }
            list[rank] = r;
            counter++;
        }
        return list;
    }
}
```