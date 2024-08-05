# Problem & Solution
- [Problem on LeetCode](https://leetcode.com/problems/min-stack/description/)
- [My Solution](https://leetcode.com/problems/min-stack/solutions/5582614/java-solution-runtime-beats-100-memory-beats-97-18)

# Demo
If the image below isn't clear, check [Demo PDF](https://drive.google.com/file/d/1bGatthFPxrMw6W-fm5EvkAuNUBiSN4hD/view?usp=sharing)
![demo.png](demo.png)

# Intuition
1. Using a linkedList to achieve flexibility in size and constant time operations on top.
2. Storing a `minSoFar` attribute in each node in the list that indicates the minimum value in the stack (from the current node until the bottom node). This way, with any addition or deletion of elements from the top, the minimum value in the stack is always tracked.

# Approach
- Pushing a node: Update the `minSoFar` in the new node.
  A new node has a default `minSoFar` value, equals to the value to be pushed.
  - if stack is empty, `minSoFar` remains unchanged.
  - else, compare the `minSoFar` of the new node, with the `minSoFar` at the top of stack, and update it accordingly.
- Popping a node: The next node (future head) already contains the previously found `minSoFar` value.


# Complexity
- Time complexity:
  - Push: **_O(1)_**
  - Pop: **_O(1)_**
  - Top: **_O(1)_**
  - GetMin: **_O(1)_**

- Space complexity:
  - **_O(n)_**, where n is the number of the pushed elements into the `MinStack` instance, because for each element there will be a node that stores a reference `next` and additional `minSoFar` value.

# Code
## Java Sample
```java
class MinStack {
    class Node{
        int value;
        int minSoFar;
        Node next;
        Node(int value, Node next){
            this.value = value;
            this.minSoFar = value;
            this.next = next;
        }
    }
    private Node top;

    public MinStack() {
        top = null;
    }

    public void push(int val) {
        Node node = new Node(val, null);
        if(top == null){
            top = node;
            return;
        }
        node.next = top;        
        if(node.minSoFar >= top.minSoFar)
           node.minSoFar = top.minSoFar;

        top = node;
    }

    public void pop() {
        top=top.next;
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return top.minSoFar;
    }
}
```
## JavaScript Sample
```javascript
class MinStack{
    constructor(){
        this.stack = [];
    }
    push(){
      var arr = [val, val];
      if(this.stack.length == 0){
        this.stack.push(arr);
        return;
      }
      arr[1] = Math.min(arr[1], this.stack[this.stack.length - 1][1])
      this.stack.push(arr)
    }
    pop(){
      this.stack.pop();
    }
    top(){
      return this.stack[this.stack.length - 1][0]
    }
    getMin(){
      return this.stack[this.stack.length - 1][1]
    }
}
```