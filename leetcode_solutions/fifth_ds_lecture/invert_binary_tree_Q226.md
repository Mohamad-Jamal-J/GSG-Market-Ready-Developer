## Problem
https://leetcode.com/problems/invert-binary-tree

## Java Code

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
```