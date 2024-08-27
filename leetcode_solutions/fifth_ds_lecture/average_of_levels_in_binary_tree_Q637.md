## Problem
https://leetcode.com/problems/average-of-levels-in-binary-tree/

## Java Code

```java
class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Double> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return list;

        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            double sum = 0;
            double counter = 0;
            for(int i = 0; i < level; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                counter++;

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(sum/counter);
        }
        return list;
    }
}
```