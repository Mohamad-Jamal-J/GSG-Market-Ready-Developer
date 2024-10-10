## Problem
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

## Java Code

```java
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int counter = 0, sum = 0;
        threshold *= k;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        if(sum >= threshold){
            counter++;
        }

        for(int i = k; i < arr.length ; i++){
            sum = sum - arr[i-k] + arr[i];
            if(sum >= threshold){
                counter++;
            }
        }
        return counter;
    }
}
```