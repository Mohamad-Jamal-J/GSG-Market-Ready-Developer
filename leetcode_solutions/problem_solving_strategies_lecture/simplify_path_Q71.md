## Problem

https://leetcode.com/problems/simplify-path/

## Java Code
### Solution 1: Using Stack
```java
class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str: dirs){
            if(!str.isEmpty() && !str.equals(".") && !str.equals("..")){
                stack.push(str);
            }else if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String str: stack){
            sb.append(str).append("/");
        }
        if(sb.length() > 1){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
```
### Solution 2: Without Stack
```java
class Solution {
    public String simplifyPath(String path) {
       String[] dirs = path.split("/");
       StringBuilder sb = new StringBuilder();
       for(String str: dirs){
            if(!str.isEmpty() && !str.equals(".") && !str.equals("..")){
                sb.append("/").append(str);
            }else if(str.equals("..") && !sb.isEmpty()){
                sb.delete(sb.lastIndexOf("/"), sb.length());
            }
        }
        return sb.isEmpty()? "/":sb.toString();
    }
}
```