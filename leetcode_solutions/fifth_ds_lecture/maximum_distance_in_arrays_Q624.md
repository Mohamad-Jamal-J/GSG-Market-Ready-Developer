## Problem
https://leetcode.com/problems/maximum-distance-in-arrays/

## Java Code

```java
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> array1 = arrays.get(0);
        int min = array1.get(0);
        int max = array1.get(array1.size()-1);

        int distance = 0;
        for(List<Integer> array: arrays){
            if(array==array1)
                continue;

            int currMin = array.get(0);
            int currMax = array.get(array.size() - 1);

            distance = Math.max(distance, Math.abs(currMax - min));
            distance = Math.max(distance, Math.abs(max - currMin));

            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        return distance;
    }
}
```