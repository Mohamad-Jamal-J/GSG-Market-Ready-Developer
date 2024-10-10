# Problem & ValidAnagram
- [Problem on LeetCode](https://leetcode.com/problems/valid-anagram/)
- [My Solution](https://leetcode.com/problems/valid-anagram/solutions/5627889/java-solution-counting-array/)

# Intuition
Each letter in string 1 must have the same number of occurrences as in string 2 (for the same letter).

# Approach
Use an array `counter` of size 26 (number of lower english letters). Elements in the array represents the number of occurrences for each character.
Occurrences of character `x` can be found at: `counter[x - 'a']`.
- Iterate over the first string and increment the occurrences of each letter found.
- Iterate over the second string, for each letter found:
  - If the no. of occurrences for this letter is zero, the two strings are not anagrams.
  - else, decrement the no. of occurrences for this letter.

# Complexity
- Time complexity:
  **_O(n)_**: We only need to iterate over each String linearly and separately.

- Space complexity:
  **_O(1)_**: Array of 26 integers takes up to 64 bytes which is negligible.


# Code
```java
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (char c : s.toCharArray())
            counter[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (counter[c - 'a'] == 0)
                return false;
            counter[c - 'a']--;
        }
        return true;
    }
}
```