# Demo
[Check My Demo Here](https://drive.google.com/file/d/15sC9yj6RzYQStDE0VJm7rGe7me7HxiTO/view?usp=drive_link)

# Intuition

- Adding `1` to a number less than `9` is only one step.
- Adding `1` to a number equal to `9` requires making it `0`, and adding `1` to the digits on its left (repeatedly).
- given there are no leading `0`'s means that if the leftmost digit is `0`, it means that the list was full of `9`'s, and we need to place a new digit `1` on the left.
# Approach
Start from the rightmost digit (last element of the `digits`):
- If current digit is less than `9` add `1` to it and return `digits`.
- else (if equal to `9`), make the current digit `0`, add `1` to the next digit.
- if the leftmost digit is 0, return a new array representing the number `1 x 10^n`, where `n` is the size of `digits`.

# Complexity
- Time complexity -
  **_O(k)_**: where k is the size of `digits`, the worst scenario is when `digits` is full of `9`'s.

- Space complexity -
  **_O(k)_**: worst case scenario involves instantiating a new array of size k+1.

# Code
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1 ; i>=0 ;i--){
          if(digits[i]<9){
            digits[i]++;
            return digits;
          }
          digits[i] = 0;
        }
    
        if(digits[0]==0){
          int[] newDigits = new int[n+1];
          newDigits[0]=1;
          return newDigits;
        }
    
        return digits;
    }
}
```