## Problem

https://leetcode.com/problems/move-zeroes/

## Java Code

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length && nums[i] != 0){ // Find the index of the first 0
            i++;
        }
        for(int j=i+1; j < nums.length; j++){ // Move zeros to the end
            if(0 != nums[j]){
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
```