# Problem & Solution
- [Problem on LeetCode](https://leetcode.com/problems/balanced-binary-tree/)
- [My Solution](https://leetcode.com/problems/balanced-binary-tree/solutions/5640477/java-solution-beats-100/)

![submission.png](submission.png)


# Intuition
For each node in the tree, find the heights of the left and right subtrees. And at any point, if the absolute difference between these two heights is more than 1, then the tree is unbalanced.

# Complexity
- Time complexity: ***O(N)***, The entire tree will be traversed only once.

- Space complexity: **_O(N)_**, The height of the tree in worst case (unbalanced linear tree) could be equal to `N`, which requires `N` recursive stack calls.
# Code
## Java Sample
```java
class Solution { 
  public boolean isBalanced(TreeNode root) {
      if(root == null)
          return true;

      return getHeight(root) != -1 ;
  }
  private int getHeight(TreeNode node){ // find the height of a tree/ subtree, and returns -1 in case the tree is unbalanced.
      if(node == null) 
          return 0;
      int left = getHeight(node.left);
      if(left == -1)
        return -1;
      int right= getHeight(node.right);
      if (right == -1)
        return -1;
  
      int det = left - right;
      if (det > 1 || det < -1)
        return -1;
  
      return 1 + (left >= right? left:right);
  }
}
```
