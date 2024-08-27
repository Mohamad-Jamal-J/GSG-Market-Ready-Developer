# Problem Description
https://leetcode.com/problems/best-time-to-buy-and-sell-stock

# Code
## Java Sample
```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, buy_price = prices[0];
        for (int price : prices) {
            if (price < buy_price)
                buy_price = price;
            else {
                int diff = price - buy_price;
                profit = Math.max(profit, diff);
            }
        }
        return profit;
    }
}
```
