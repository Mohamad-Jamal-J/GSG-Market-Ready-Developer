## Problem
https://leetcode.com/problems/minimum-depth-of-binary-tree/
## Java Code

```java
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(root.left == null && root.right == null)
            return 1;

        if(root.right == null)
            return left+1;

        if(root.left == null)
            return right+1;

        return 1 + Math.min(left, right);
    }

}
```