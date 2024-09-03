## Problem

https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

## Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        boolean skip = false;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){ // if different numbers don't skip next occurrence.
                nums[++i] = nums[j];
                skip = false;
            }else if(!skip){ // if duplicate and allowed, skip next occurrence.
                nums[++i] = nums[j];
                skip = true;
            }
        }
        return i+1;
    }
}
```