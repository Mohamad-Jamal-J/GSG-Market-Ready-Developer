## Problem
https://leetcode.com/problems/roman-to-integer

## Java Code
```java
class Solution {
    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0 ; i< s.length(); i++ ){
            int romanC = roman(s.charAt(i));
            if (i+1 < s.length()) {
                char next = s.charAt(i+1);
                if (romanC < roman(next)) {
                    sum -= romanC;
                }else{
                    sum += romanC;
                }
            }
            else sum+= romanC;
        }
        return sum;
    }
    public static int roman(char s) {
        return switch (s) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }
}
```

#### Using Hashmap
```java
class Solution {
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        int sum = 0;
        for (int i = 0 ; i< s.length(); i++ ){
            int romanC = roman.get(s.charAt(i));
            if (i+1 < s.length()) {
                char next = s.charAt(i+1);
                if (romanC < roman.get(next)) {
                    sum -= romanC;
                }else{
                    sum += romanC;
                }
            }
            else sum+= romanC;
        }
        return sum;
    }
}
```