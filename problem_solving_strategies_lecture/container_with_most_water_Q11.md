## Problem
https://leetcode.com/problems/container-with-most-water/description/

## Java Code

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;

        while (l < r) {
            int currH = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, currH * (r - l));

            while(height[l] <= currH && l < r){
                l++;
            }
            while(height[r] <= currH  && l < r){
                r--;
            }
        }
        return maxArea;
    }
}
```