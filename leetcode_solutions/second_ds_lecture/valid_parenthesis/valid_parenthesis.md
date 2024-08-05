# Problem & Solution
- [Problem on LeetCode](https://leetcode.com/problems/valid-parentheses)
- [My Solution](https://leetcode.com/problems/valid-parentheses/solutions/5586717/java-solution-beats-98-89)


# Intuition
We can use a stack to track the closing parentheses that are expected, based on the opening parentheses we see.

# Approach
- If we see an opening parenthesis, push the corresponding closing parenthesis into the stack.
- If we see a closing parenthesis `p`:
  - If the stack is empty or the popped value from the stack doesn't match `p`, return false (invalid string).
- Finally, after checking all the characters, if the string is valid, the stack need to be empty.

# Complexity
- Time complexity: **_O(n)_**, where **n** is the length of the given string `s`.

- Space complexity: **_O(n)_**, where **n** is the number of open parenthesis in the given string `s`, that we need to push into the stack.

# Code
```java
class Solution {
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
```