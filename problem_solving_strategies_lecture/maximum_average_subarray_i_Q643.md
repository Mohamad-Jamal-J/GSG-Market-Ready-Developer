## Problem
https://leetcode.com/problems/maximum-average-subarray-i/
## Java Code

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        maxSum = sum;
        for(int right = k; right < nums.length; right++){
            sum = sum - nums[right - k] + nums[right];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum * 1.0 / k;
    }
}
```