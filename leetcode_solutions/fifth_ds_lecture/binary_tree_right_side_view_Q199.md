## Problem
https://leetcode.com/problems/binary-tree-right-side-view
## Java Code

```java
class Solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return list;
        rightSideView(root, 0);
        return list;
    }
    private void rightSideView(TreeNode node, int level){
        if(node == null)
            return;

        if(level >= list.size())
            list.add(node.val);

        rightSideView(node.right, level+1);
        rightSideView(node.left, level+1);
    }


}
```

### Using queue
```java
class Solution {
    List<Integer> list = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return list;

        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i<level; i++){
                TreeNode node = queue.poll();
                if(i==0)
                    list.add(node.val);
                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left!=null)
                    queue.offer(node.left);
            }
        }
        return list;
    }
}
```