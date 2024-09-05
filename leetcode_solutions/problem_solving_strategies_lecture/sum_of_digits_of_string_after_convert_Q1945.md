## Problem

https://leetcode.com/problems/sum-of-digits-of-string-after-convert/

## Java Code

```java
class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(char c: s.toCharArray()){
            int curr = c - 96;
            while(curr > 0){
                sum+= curr %10;
                curr /= 10;
            }
        }
        while(k-- > 1){
            int curr = sum;
            sum = 0;
            while(curr > 0){
                sum += curr % 10;
                curr /= 10;
            }
        }
        return sum;
    }
}
```