package tasks.second_ds_lecture.valid_parenthesis;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char p: s.toCharArray()){
            switch(p){
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty() || p != stack.pop())
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
