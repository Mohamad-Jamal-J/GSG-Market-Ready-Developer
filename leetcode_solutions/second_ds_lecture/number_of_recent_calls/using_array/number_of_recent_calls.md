# Solution & Demo
- [Problem on LeetCode](https://leetcode.com/problems/number-of-recent-calls)
- [My Solution](https://leetcode.com/problems/number-of-recent-calls/solutions/5587987/java-solution-beats-97-81-two-pointers-array/)

# Intuition
Use a fixed size array with two pointers to store the timestamps of pings. This allows constant time operations for adding and removing pings. This way we can track the number of pings that have occurred in the last 3000ms easily.

# Approach
Maintain two pointers, `old` and `recent`, to track the oldest (index of the first ping in the last 3000ms) and the most recent pings within `[t-3000, t]` window.
Ping:
- Increment `recent` and store the current timestamp `t` in `calls` there.
- Increment `old` to remove any pings outside the `[t-3000, t]` window.
At any point, the number of valid pings would be `recent-old+1`.

# Complexity
- Time complexity: Ping: **_O(1)_**
- Space complexity: **_O(1)_** (The size of the array calls is fixed at 10,000)

# Code
```java
class RecentCounter {
    int[] calls;
    int old;
    int recent;
    public RecentCounter() {
        calls = new int[10000];
        old = 0;
        recent = -1;
    }

    public int ping(int t) {
        calls[++recent] = t;
        while(old <= recent && calls[old] < t - 3000)
            old++;

        return recent-old+1;
    }
}
```