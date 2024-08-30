## Problem

https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

## Java Code
### Solution 1: Using a Stack
```java
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);            
            }
        }
        char[] result = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return new String(result);
    }
}
```
### Solution 2: Using Two Pointers
```java
class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (i == 0 || arr[i - 1] != arr[j]) {
                arr[i++] = arr[j];
            } else {
                i--;
            }
        }
        return new String(arr, 0, i);
    }
}
```