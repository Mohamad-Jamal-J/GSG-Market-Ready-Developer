## Problem
https://leetcode.com/problems/climbing-stairs/

## Java Code

```java
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int ways = 0, prev = 1, prevv = 1;
        for (int i = 2; i <= n; i++){
            ways = prev + prevv;
            prev = ways;
            prevv = ways - prevv;
        }
        return ways;
    }
}
```

## Using tabulation
```java
class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
```