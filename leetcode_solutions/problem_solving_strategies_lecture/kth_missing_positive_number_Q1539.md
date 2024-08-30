## Problem
https://leetcode.com/problems/kth-missing-positive-number/

## Java Code
### Solution 1 _O(N)_
```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr = 1, i = 0;
        while(k > 0){
            if(i < arr.length && curr == arr[i]){
                i++;
            }else{
                k--;
            }
            if(k == 0){
                return curr;
            }
            curr++;
        }
        return arr.length + k;
    }
}
```
### Solution 2: Improvement on Solution 1 _O(N)_
```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while(k > 0){
            if(i < arr.length && arr[i] < k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}
```
### Solution 3: Binary Search _O(log N)_
#### Approach:
* Looking for the Kth missing value:
  * if `arr[i] - i > k`: there are `k` or more missing values at `[0, i]`, then `kth_missing < arr[i]`.
  * else: there are `k - 1` or fewer missing values at `[0, i]`, then `kth_missing > arr[i]`.

If we find the smallest index `left` such that `arr[left] - left >= k` (the index where there are at least k missing elements before it), and shift it to the right by `k`, then we have our answer.

```java
class Solution {
  public int findKthPositive(int[] arr, int k) {
    int left = 0, right = arr.length;
    while(left < right){
      int mid = (left + right) / 2;
      if(arr[mid] - mid > k){ // look lower
        right = mid;
      }else{ // look higher
        left = mid+1;
      }
    }
    // here left will be the smallest index such that arr[left] - left >= k.
    // so left + k = original[left + k - 1] = kth missing value
    // where original is the array with no missing values.
    return left + k;
  }
}
```
#### How to Derive the Relationship above:
1- Keep in mind that the numbers are positive and strictly increasing. Given this:
The array with missing values `arr = [2,3,4,6]`: with indices: 0,1,2,3 was originally: `original = [1,2,3,4,5,6]` with indices: 0,1,2,3,4,5
Notice that `original[i] - i = 1` for every i in `[0, n-1]`. However, if we examine `arr`, we see that `arr[0] - 0 = 2`, which indicates that a value is missing at `i = 0`. Similarly, `arr[3] - 3 = 3`, indicates that there are 2 missing values located at `[0, 3]`.

We can benefit from this fact as following:
* **Looking for the 1st missing value:**
  * if `arr[i] - i == 1`, so `arr[i]` is in place (0 missing values at `[0, i]`), then the 1st missing value is higher than `arr[i]`.
  * else if `arr[i] - i < 1` this case is not possible when k = 1.
  * else: `arr[i] - i > 1`, so `arr[i]` was shifted 1 or more times to the left (1 or more missing values at `[0, i]`), then the 1st missing value can surely be located at `[0, i]`.

* **Looking for the 2nd missing value:**
  * if `arr[i] - i == 2`, so `arr[i]` was shifted only 1 time to the left (1 missing value at `[0, i]`), then the 2nd missing value is higher than `arr[i]`.
  * else if `arr[i] - i < 2` this is similar to `arr[i] - i == 1`, so we need to look higher than `arr[i]`.
  * else: `arr[i] - i > 2`, so `arr[i]` was shifted 2 or more times to the left (2 or more missing values at `[0, i]`), then the 2nd missing value can surely be located at `[0, i]`.

Now let's generalize this to find the kth missing:
* **Looking for the Kth missing value:**
  * if `arr[i] - i == k`, so `arr[i]` was shifted `k - 1` time to the left (`k - 1` missing values at `[0, i]`), then the kth missing value is higher than `arr[i]`.
  * else if `arr[i] - i < k`, there are less than `k - 1` missing numbers at `[0, i]`, so we need to look higher than `arr[i]`.
  * else: `arr[i] - i > k`, so `arr[i]` was shifted k or more times to the left (k or more missing values at `[0, i]`), then the kth missing value can surely be located at `[0, i]`.

**The Final Relationship:**
* Looking for the Kth missing value:
  * if `arr[i] - i > k`, there are `k` or more missing values at `[0, i]`, then `kth_missing < arr[i]`.
  * else: `arr[i] - i <= k`, there are `k - 1` or fewer missing values at `[0, i]`, then `kth_missing > arr[i]`.
