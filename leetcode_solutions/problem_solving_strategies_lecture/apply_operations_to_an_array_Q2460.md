## Problem

https://leetcode.com/problems/apply-operations-to-an-array/

## Java Code

```java
class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                nums[i-1] *= 2;
                nums[i] = 0;
            }
        }

        int i = 0;
        while(i < nums.length && nums[i] != 0){ // Find the first index with 0 value
            i++;
        }
        for(int j = i+1; j < nums.length; j++){ // Move zeros to the end
            if(nums[j] != 0){
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }
        return nums;
    }
}
```