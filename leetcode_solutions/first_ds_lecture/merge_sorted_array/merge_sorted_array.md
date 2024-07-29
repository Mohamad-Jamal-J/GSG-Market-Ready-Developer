# Demo

[Check My Demo Here](https://drive.google.com/file/d/16RJFg5VPlbtcovPHofe32YABF7HeC6qa/view?usp=drive_link)

# Intuition
- The data is sorted in non-decreasing order in both arrays.
- `m` the number of non-zero elements in `nums1`.
- `n` the size of `nums2`.
- Introduce a variable `k` to keep track of the last index, which the numbers from `m+n-1` down to `k` are sorted (descending).
- Why using the end and not the start? using the start might need some shifting for elements.

# Approach
- Start filling `nums1` at `k` with the maximum value between the largest elements in each array (`nums1[m]`, `nums2[n]`), and decrement the current pointer of the chosen array.
- Keep doing the above until eiter `m` or `n` are less than zero:
  - If both `m` and `n` are less than zero, then we're done. 
  - else if `m > 0` (all `nums2` elements have been put at the end of `nums1`) and `nums1[0:m]` elements are already in place, and we're done. 
  - else (`n > 0`, all `nums1[0:m]` elements have been put at the end of `nums1`), then fill the remaining elements in `nums1[0:k]` with `nums2[0:n]` values.

# Complexity
- Time complexity -
  **_O(k)_**: where `k = m+n` is the size of `nums1`.

- Space complexity -
  **_O(1)_**: No extra space is needed.

# Code
```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = m+n-1;
    m--;
    n--;
    while(m >= 0 && n >= 0)
      nums1[k--] = nums1[m] > nums2[n] ? nums1[m--]: nums2[n--];
    
    while (n >= 0)
      nums1[k--] = nums2[n--];
  }
}
```