# Problem & ValidAnagram
- [Problem on LeetCode](https://leetcode.com/problems/number-of-good-pairs/)
- [My Solution](https://leetcode.com/problems/number-of-good-pairs/solutions/5628069/java-solution-beats-100-using-counting-array-and-permutation-logic/)

# Intuition
We need to track the number of occurrences of each number.
let `n` be the number of occurrences of value x. If another x was found in the array --> then we have additional `n` pairs with the newly found x.

# Approach
Use a variable `counter` to track the number of good pairs, and `arr`: array of size 100, Occurrences of value x can be found via: `arr[x-1]` (given the constraint on values being in range [1:100]).
- Iterate over the given array, and for each value:
  - If it's the first occurrence of this value, set it to 1: `arr[x-1] = 1`.
  - else, increase `counter` by the number of occurrences and increment the latter: `counter += arr[x-1]++`.

# Complexity
- Time complexity:
  **_O(n)_**: We only need to iterate over the given array once.

- Space complexity:
  **_O(1)_**: array of 100 integers takes up to 400 bytes which is negligible.


# Code
```java
public class NumGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int counter = 0;
        int[] arr = new int[100];
        for(int x : nums)
            if(arr[x-1] == 0)
                arr[x-1] = 1;
            else
                counter += arr[x-1]++;
        return counter;
    }
}
```