## Problem

https://leetcode.com/problems/minimum-size-subarray-sum/

## Java Code

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for(int left = 0, right = 0; right < nums.length; right++){
            sum += nums[right];
            while(left < nums.length && sum >= target){
                min = Math.min(min, right - left + 1); 
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
```