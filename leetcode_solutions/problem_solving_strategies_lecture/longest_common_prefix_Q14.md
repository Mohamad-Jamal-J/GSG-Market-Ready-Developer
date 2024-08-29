## Problem
https://leetcode.com/problems/longest-common-prefix

## Java Code

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            for(String str: strs){
                if(i >= str.length() || str.charAt(i) != strs[0].charAt(i) )
                    return prefix.toString();
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}
```