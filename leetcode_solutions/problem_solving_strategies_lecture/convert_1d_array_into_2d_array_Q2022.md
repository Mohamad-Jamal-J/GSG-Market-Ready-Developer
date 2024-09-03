## Problem

https://leetcode.com/problems/convert-1d-array-into-2d-array/

## Java Code

```java
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if( m * n != original.length){
            return new int[0][];
        }
        int curr = 0;
        int[][] matrix = new int[m][n];
        for(int row = 0; row < m; row++){
            for(int column = 0; column < n; column++){
                matrix[row][column] = original[curr++];
            }
        }
        return matrix;
    }
}
```