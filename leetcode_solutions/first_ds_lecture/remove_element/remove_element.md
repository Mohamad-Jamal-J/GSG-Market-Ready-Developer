# Demo
[Check My Demo Here](https://drive.google.com/file/d/1tirROjr15opHV7Bk3VS0uF4WHOMeMXko/view?usp=sharing)

# Intuition
Traverse `nums`, if we encounter an element that equals `val` we skip it but keep a flag on its index for later.

# Approach
Using a flag variable `n` to keep track of the last index in which the numbers from `0` up to `n-1` are not equal to `val`:
- Whenever we encounter an element that is equal to `val`, we skip it and move forward.
- else (element not equal to `val`), then we store it at `n` and move `n` forward.
- By the end all non `val` elements will be at `nums[0:n-1]`

# Complexity
- Time complexity:
  _**O(k):**_ where k is the size of `nums`.

- Space complexity:
  _**O(1):**_ No extra space is needed.

# Code
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for(int i = 0 ; i < nums.length; i++)
            if(nums[i]!=val)
                nums[n++] = nums[i];
        return n;
    }
}
```