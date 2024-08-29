## Problem
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

## Java Code

```java
class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int counter = 0;
        for(int j = 2; j < chars.length; j++){
            if (chars[j - 2] != chars[j - 1]
                    && chars[j - 2] != chars[j]
                    && chars[j - 1] != chars[j]){
                counter++;
            }
        }
        return counter;
    }
}
```