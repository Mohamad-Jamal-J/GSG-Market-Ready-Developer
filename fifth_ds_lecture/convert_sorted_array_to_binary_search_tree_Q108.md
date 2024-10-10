## Problem
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

## Java Code

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        return balance(nums, 0, nums.length-1);
    }
    private TreeNode balance(int[] nums, int start, int end){
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = balance(nums, start, mid-1);
        root.right = balance(nums, mid+1, end);
        return root;
    }
}
```