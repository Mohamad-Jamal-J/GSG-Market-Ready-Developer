# Demo

[Check My Demo Here](https://drive.google.com/file/d/1-aVXOjebo2QsgNTVm2bSc18ElfPW7oxv/view?usp=drive_link)

# Intuition
- The data is sorted in non-decreasing order, so duplicated values are found next to each other, there's no need to search for them using brute force approach.
- Introduce a variable `n` to keep track of the last index in which the numbers from `0` up to `n` are unique:

# Approach
- Whenever we encounter an element that is equal to the element at index `n`, we skip it and move forward.
- If we encounter an element that isn't equal to the element at `n`, then we store the former at `n+1`.

# Complexity
- Time complexity -
  **_O(n)_**: where `n` is the size of `nums`.

- Space complexity -
  **_O(1)_**: No extra space is needed.

# Code
```java
class Solution {
  public int removeDuplicates(int[] nums) {
    int n=0;
    for(int i = 1; i < nums.length; i++)
      if(nums[n] != nums[i])
        nums[++n]=nums[i];
    return n+1;
  }
}
```