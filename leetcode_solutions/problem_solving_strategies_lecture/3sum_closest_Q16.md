## Problem

https://leetcode.com/problems/3sum-closest/

## Java Code

### Solution 1: Brute Force
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2], minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    int currSum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - currSum) < Math.abs(target-sum)){
                        sum = currSum;
                    }
                }    
            }
        }
        return sum; 
    }
}
```

### Solution 2: Sort and search
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - currSum) < Math.abs(target - sum)){
                    sum = currSum;
                }

                if(currSum < target){
                    left++;
                }else if(currSum > target){
                    right--;
                }else{
                    return currSum;
                }
            }
        }
        return sum; 
    }
}
```
### Solution 3: Counting Sort and search (best approach)
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // counting sort O(N)
        int[] occurrences = new int[2001];
        for (int num :nums)
            occurrences[num + 1000]++;

        int idx = 0;
        for (int j = 0; j < 2001; j++) {
            while (occurrences[j]-- > 0) {
                nums[idx++] = j - 1000;
            }
        }

        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - currSum) < Math.abs(target - sum)){
                    sum = currSum;
                }

                if(currSum < target){
                    left++;
                }else if(currSum > target){
                    right--;
                }else{
                    return currSum;
                }
            }
        }
        return sum; 
    }
}
```