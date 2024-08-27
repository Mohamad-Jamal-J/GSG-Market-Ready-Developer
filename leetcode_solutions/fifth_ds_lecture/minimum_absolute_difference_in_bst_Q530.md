## Problem
https://leetcode.com/problems/minimum-absolute-difference-in-bst/

## Java Code

```java
class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }
    private void inOrder(TreeNode root){
        if(root == null)
            return;

        inOrder(root.left);


        if(prev != null)
            min = Math.min(root.val-prev.val, min);

        prev = root;
        inOrder(root.right);
    }

}
```