## Problem
https://leetcode.com/problems/snake-in-matrix/description/

## Java Code

```java
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0 , j = 0;
        for(String command: commands){
            switch(command.charAt(0)){
                case 'R' -> j++;
                case 'L' -> j--;
                case 'D' -> i++;
                default ->  i--;
            }
        }
        return i * n + j;
    }
}
```