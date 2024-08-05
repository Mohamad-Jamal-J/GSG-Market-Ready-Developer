package tasks.second_ds_lecture.implement_queue_using_stacks;

import java.util.Stack;

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