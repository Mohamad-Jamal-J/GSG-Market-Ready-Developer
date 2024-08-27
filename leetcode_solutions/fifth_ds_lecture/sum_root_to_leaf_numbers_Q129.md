## Problem
https://leetcode.com/problems/sum-root-to-leaf-numbers

## Java Code

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbers(root, 0);
    }
    private int sumNumbers(TreeNode node, int sum){
        if(node == null)
            return 0;

        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) {
            return sum;
        }
        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }
}
```