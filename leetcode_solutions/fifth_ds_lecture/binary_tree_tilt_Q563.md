## Problem
https://leetcode.com/problems/binary-tree-tilt

## Java Code

```java
class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        postOrderSum(root);
        return sum;
    }
    private int postOrderSum(TreeNode node){
        if(node==null)
            return 0;
        int left = postOrderSum(node.left);
        int right = postOrderSum(node.right);
        sum += Math.abs(left - right);
        return left+right+node.val;
    }
}
```