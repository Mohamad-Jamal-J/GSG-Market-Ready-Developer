# Solution & Demo
- [Problem on LeetCode](https://leetcode.com/problems/number-of-recent-calls)
- [My Solution](https://leetcode.com/problems/number-of-recent-calls/solutions/5588023/java-solution-beats-37-16-using-queue/)

# Intuition
Use a queue to store the timestamps of pings. This allows constant time operations for adding and removing pings. This way, we can track the number of pings that have occurred in the last 3000ms easily.
# Approach
Maintain a queue `calls` to store the timestamps of pings.

1. Enqueue the current timestamp `t` to `calls`.
2. Dequeue pings outside the `[t-3000, t]` window.
   At any point, the size of `calls` represents the number of valid pings within the last 3000ms.

# Complexity
- Time complexity: Ping: **_O(1)_**
- Space complexity: **_O(n)_**, where n is the number of pings stored in the queue.

# Code
```java
class RecentCounter {
    Queue<Integer> calls;
    public RecentCounter() {
        calls = new LinkedList<>();
    }

    public int ping(int t) {
        calls.add(t);
        while(!calls.isEmpty() && calls.peek() < t - 3000)
            calls.remove();

        return calls.size();
    }
}
```