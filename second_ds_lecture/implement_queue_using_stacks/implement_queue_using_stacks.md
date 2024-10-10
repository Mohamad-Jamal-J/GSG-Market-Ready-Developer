# Problem & Solution
- [Problem on LeetCode](https://leetcode.com/problems/implement-queue-using-stacks)
- [My Solution](https://leetcode.com/problems/implement-queue-using-stacks/solutions/5587803/java-solution-beats-100/)

# Intuition
Stack: Last In, First Out (LIFO)
Queue: First In, First Out (FIFO)
By using two stacks, we can simulate the FIFO behavior of a queue.

# Approach
`stack1` is used for enqueue (push) operations.
`stack2` is used for dequeue (pop) and peek operations.
- Push Operation: Push the element into `stack1`.
- Pop and Peek Operations (performed on `stack2`):
  If `stack2` is empty, transfer elements from `stack1` to `stack2`.
- Empty Operation: The queue is empty if both `stack1` and `stack2` are empty.

# Complexity
- Time complexity:
  **_O(1)_**: for all operations.

- Space complexity:
  **_O(1)_**: no extra space is needed.


# Code
```java
class MyQueue {
    Stack<Integer> stack1, stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        transfer();
        return stack2.pop();
    }
    
    public int peek() {
        transfer();
        return stack2.peek();   
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    private void transfer(){
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    }
}
```