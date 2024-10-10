## Problem

https://leetcode.com/problems/reverse-vowels-of-a-string/

## Java Code

```java
class Solution {
    private final static Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right){
            while(!vowels.contains(str[left]) && left < right){
                left++;
            }
            while(!vowels.contains(str[right]) && left < right){
                right--;
            }
            if(left < right){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(str);

    }
}
```