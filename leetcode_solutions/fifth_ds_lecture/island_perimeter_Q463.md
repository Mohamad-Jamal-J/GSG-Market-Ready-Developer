## Problem
https://leetcode.com/problems/island-perimeter
## Java Code

```java
class Solution {
    public int islandPerimeter(int[][] grid) {
        int sides = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    sides += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        sides -= 2;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        sides -= 2;
                    }
                }
            }
        }
        return sides;
    }
}
```