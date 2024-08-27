# Problem Description
https://leetcode.com/problems/find-the-town-judge

# Code
## Java Sample
```java
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n== 1 && trust.length == 0)
            return 1;
        int[] trustStrength = new int[n+1];
        for(int[] T: trust){
            trustStrength[T[1]]++;
            trustStrength[T[0]]--;
        }

        for(int i = 0; i < trustStrength.length ;i++){
            if(trustStrength[i] == n-1)
                return i;
        }
        return -1;
    }
}
```
